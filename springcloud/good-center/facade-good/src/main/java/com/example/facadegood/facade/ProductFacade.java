package com.example.facadegood.facade;

import com.example.basegood.input.DecreaseStockInput;
import com.example.basegood.input.ProductInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author tang
 * @Classname ProductFacade
 * @Description TODO
 * @Date 2019/12/26 22:36
 */
@FeignClient(name = "product")
public interface ProductFacade {
    @PostMapping("/product/listForOrder")
    List<ProductInfoDTO> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
