package com.example.servicegood.controller;

import com.example.common.resultcode.BaseResult;
import com.example.basegood.input.DecreaseStockInput;
import com.example.servicegood.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品接口")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productService;

    @ApiOperation(value = "商品列表")
    @GetMapping("/list")
    public Object list() {
        //查询
        return BaseResult.success(productService.listProductGroupCategory());
    }

    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @ApiOperation(value = "获取商品列表(给订单服务用的)")
    @PostMapping("/listForOrder")
    public Object listForOrder(@RequestBody List<String> productIdList) {
        return BaseResult.success(productService.findList(productIdList));
    }

    @ApiOperation(value = "减少库存")
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
         productService.decreaseStock(decreaseStockInputList);
    }
}
