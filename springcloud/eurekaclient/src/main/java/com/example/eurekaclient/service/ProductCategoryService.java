package com.example.eurekaclient.service;

import com.example.eurekaclient.entry.model.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
