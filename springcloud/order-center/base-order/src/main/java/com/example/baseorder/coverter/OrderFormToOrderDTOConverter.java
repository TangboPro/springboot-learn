package com.example.baseorder.coverter;

import com.example.baseorder.dto.OrderDTO;
import com.example.baseorder.entry.OrderDetail;
import com.example.baseorder.form.OrderForm;
import com.example.common.utils.JacksonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Converter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class OrderFormToOrderDTOConverter extends Converter<OrderForm,OrderDTO> {

    @Override
    protected OrderDTO doForward(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setOrderDetailList(JacksonUtils.jsonToPojo(orderForm.getItems(),new TypeReference<List<OrderDetail>>() {}));
        return orderDTO;
    }

    @Override
    protected OrderForm doBackward(OrderDTO orderDTO) {
        return null;
    }
    public OrderFormToOrderDTOConverter getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private OrderFormToOrderDTOConverter singleton;

        private Singleton() {
            singleton = new OrderFormToOrderDTOConverter();
        }

        public OrderFormToOrderDTOConverter getInstance() {
            return singleton;
        }
    }
}
