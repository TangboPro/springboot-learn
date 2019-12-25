package com.example.goodservice.service;

import com.example.goodservice.entry.model.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
