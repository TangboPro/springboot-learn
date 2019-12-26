package com.example.servicegood.service.impl;

import com.example.basegood.dto.ProductInfoDTO;
import com.example.basegood.vo.ProductGroupCategoryVO;
import com.example.servicegood.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoService productService;

    @Test
    public void listProductGroupCategory() {
        List<ProductGroupCategoryVO> list = productService.listProductGroupCategory();
        System.out.println(list);
    }

    @Test
    public void findList() {
        List<String> ids = new ArrayList<>();
        ids.add("157875196366160022");
        ids.add("157875227953464068");
        List<ProductInfoDTO> list = productService.findList(ids);
        System.out.println(list);
    }
}