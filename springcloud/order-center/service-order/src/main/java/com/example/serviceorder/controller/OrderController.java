package com.example.serviceorder.controller;

import com.example.baseorder.coverter.OrderFormToOrderDTOConverter;
import com.example.baseorder.dto.OrderDTO;
import com.example.baseorder.form.OrderForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "订单接口")
@RestController
public class OrderController {

    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public Object create(@Valid OrderForm orderForm) {
        // orderForm -> orderDTO
        OrderDTO orderDTO = new OrderFormToOrderDTOConverter().convert(orderForm);
        return null;
//        OrderDTO result = orderService.create(orderDTO);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("orderId", result.getOrderId());
//        return ResultVOUtil.success(map);
    }
}
