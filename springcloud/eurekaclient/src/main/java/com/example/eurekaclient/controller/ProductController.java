package com.example.eurekaclient.controller;

import com.example.eurekaclient.common.BaseResult;
import com.example.eurekaclient.entry.params.input.DecreaseStockInput;
import com.example.eurekaclient.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productService;

    @GetMapping("/list")
    public Object list() {
        //查询
        return BaseResult.success(productService.listProductGroupCategory());
    }
    /**
     * 获取商品列表(给订单服务用的)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public Object listForOrder(@RequestBody List<String> productIdList) {
        return BaseResult.success(productService.findList(productIdList));
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
//        productService.decreaseStock(decreaseStockInputList);
    }
}
