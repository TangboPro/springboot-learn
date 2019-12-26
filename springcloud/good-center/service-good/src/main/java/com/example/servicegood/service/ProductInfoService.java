package com.example.servicegood.service;

import com.example.basegood.input.DecreaseStockInput;
import com.example.basegood.vo.ProductGroupCategoryVO;
import com.example.basegood.entry.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.basegood.dto.ProductInfoDTO;

import java.util.List;

public interface ProductInfoService extends IService<ProductInfo> {
    /**
     * 查询产品通过分类id分组
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     *
     * @return ProductGroupCategoryDTO
     */
    public List<ProductGroupCategoryVO> listProductGroupCategory();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    public List<ProductInfoDTO> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
