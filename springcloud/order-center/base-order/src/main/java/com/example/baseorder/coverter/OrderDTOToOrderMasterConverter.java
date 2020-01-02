package com.example.baseorder.coverter;

import com.example.baseorder.dto.OrderDTO;
import com.example.baseorder.entry.OrderDetail;
import com.example.baseorder.entry.OrderMaster;
import com.example.baseorder.form.OrderForm;
import com.example.common.utils.JacksonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Slf4j
public class OrderDTOToOrderMasterConverter extends Converter<OrderDTO,OrderMaster> {

    @Override
    protected  OrderMaster doForward(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setOrderId(orderDTO.getOrderId());
        orderMaster.setOrderAmount(orderDTO.getOrderAmount());
        return orderMaster;
    }

    @Override
    protected OrderDTO doBackward(OrderMaster orderMaster) {
        return null;
    }

    public OrderDTOToOrderMasterConverter getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private OrderDTOToOrderMasterConverter singleton;

        private Singleton() {
            singleton = new OrderDTOToOrderMasterConverter();
        }

        public OrderDTOToOrderMasterConverter getInstance() {
            return singleton;
        }
    }
}
