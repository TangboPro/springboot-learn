package com.example.serviceorder.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.basegood.input.DecreaseStockInput;
import com.example.basegood.input.ProductInfoDTO;
import com.example.baseorder.dto.OrderDTO;
import com.example.baseorder.entry.OrderDetail;
import com.example.baseorder.entry.OrderMaster;
import com.example.baseorder.enums.OrderStatusEnum;
import com.example.baseorder.enums.PayStatusEnum;
import com.example.facadegood.facade.ProductFacade;
import com.example.serviceorder.dao.OrderDetailMapper;
import com.example.serviceorder.dao.OrderMasterMapper;
import com.example.serviceorder.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductFacade productFacade;
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = IdUtil.objectId();

        //查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());

        List<ProductInfoDTO> productInfoDTOList = productFacade.listForOrder(productIdList).getData();

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            for (ProductInfoDTO productInfo: productInfoDTOList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);

                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(IdUtil.objectId());
                    //订单详情入库
                    orderDetailMapper.insert(orderDetail);
                }
            }
        }

        //扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productFacade.decreaseStock(decreaseStockInputList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.insert(orderMaster);
        return orderDTO;
    }
}
