package com.example.consumer.coverter;

import com.example.consumer.dto.OrderDTO;
import com.example.consumer.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderFormToOrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

//        List<OrderDetail> orderDetailList = new ArrayList<>();
//        try {
//            orderDetailList = gson.fromJson(orderForm.getItems(),
//                    new TypeToken<List<OrderDetail>>() {
//                    }.getType());
//        } catch (Exception e) {
//            log.error("【json转换】错误, string={}", orderForm.getItems());
//            throw new OrderException(ResultEnum.PARAM_ERROR);
//        }
//        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
