package com.example.goodservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodservice.dao.ProductCategoryDao;
import com.example.goodservice.entry.model.ProductCategory;
import com.example.goodservice.service.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.selectBatchIds(categoryTypeList);
    }
}