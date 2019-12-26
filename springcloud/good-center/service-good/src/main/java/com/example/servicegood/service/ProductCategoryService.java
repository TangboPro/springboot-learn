package com.example.servicegood.service;

import com.example.basegood.entry.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
