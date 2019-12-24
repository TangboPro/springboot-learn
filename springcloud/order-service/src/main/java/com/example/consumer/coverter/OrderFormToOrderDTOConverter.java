package com.example.consumer.coverter;

import com.example.consumer.dto.OrderDTO;
import com.example.consumer.form.OrderForm;
import com.google.common.base.Converter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderFormToOrderDTOConverter extends Converter<OrderForm,OrderDTO> {

    public static OrderFormToOrderDTOConverter instance;
    @Override
    protected OrderDTO doForward(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        return orderDTO;
    }

    @Override
    protected OrderForm doBackward(OrderDTO orderDTO) {
        return null;
    }
    public OrderFormToOrderDTOConverter getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;

        private OrderFormToOrderDTOConverter singleton;

        // JVM会保证此方法绝对只调用一次

        private Singleton() {
            singleton = new OrderFormToOrderDTOConverter();
        }

        public OrderFormToOrderDTOConverter getInstance() {
            return singleton;
        }
    }
}
