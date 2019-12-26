package com.example.facadegood.facade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * @author tang
 * @Classname ProductFacade
 * @Description TODO
 * @Date 2019/12/26 22:36
 */
@FeignClient(name = "product")
public class ProductFacade {
}
