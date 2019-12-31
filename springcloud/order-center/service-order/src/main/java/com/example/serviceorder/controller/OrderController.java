package com.example.serviceorder.controller;

import com.example.baseorder.coverter.OrderFormToOrderDTOConverter;
import com.example.baseorder.dto.OrderDTO;
import com.example.baseorder.form.OrderForm;
import com.example.common.resultcode.BaseResult;
import com.example.serviceorder.service.OrderService;
import com.example.serviceorder.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "订单接口")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public Object create(@Valid OrderForm orderForm) {

        OrderDTO orderDTO = new OrderFormToOrderDTOConverter().convert(orderForm);
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("orderId", result.getOrderId());
        return BaseResult.success(returnMap);
    }
}
