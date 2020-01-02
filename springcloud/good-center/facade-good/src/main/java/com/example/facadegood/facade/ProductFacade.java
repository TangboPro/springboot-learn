package com.example.facadegood.facade;

import com.example.basegood.input.DecreaseStockInput;
import com.example.basegood.dto.ProductInfoDTO;
import com.example.common.resultcode.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author tang
 * @Classname ProductFacade
 * @Description TODO
 * @Date 2019/12/26 22:36
 */
@FeignClient(name = "good-service")
public interface ProductFacade {
    @PostMapping("/product/listForOrder")
    BaseResult<List<ProductInfoDTO>> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
