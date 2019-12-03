package com.example.eurekaclient.service;

import com.example.eurekaclient.entry.vo.ProductGroupCategoryVO;
import com.example.eurekaclient.entry.model.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eurekaclient.entry.dto.ProductInfoDTO;

import java.util.List;

public interface ProductInfoService extends IService<ProductInfo>{
    /**
     * 查询产品通过分类id分组
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     * @return ProductGroupCategoryDTO
     */
    public List<ProductGroupCategoryVO> listProductGroupCategory();

    public List<ProductInfoDTO> findList(List<String> productIdList);
}
