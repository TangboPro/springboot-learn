package com.example.eurekaclient.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.eurekaclient.common.enums.ProductStatusEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eurekaclient.entry.vo.ProductGroupCategoryVO;
import com.example.eurekaclient.entry.vo.ProductInfoVO;
import com.example.eurekaclient.entry.model.ProductCategory;
import com.example.eurekaclient.entry.dto.ProductInfoDTO;
import com.example.eurekaclient.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eurekaclient.entry.model.ProductInfo;
import com.example.eurekaclient.dao.ProductInfoDao;
import com.example.eurekaclient.service.ProductInfoService;
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService{


    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoDao productInfoDao;
    @Override
    public List<ProductGroupCategoryVO> listProductGroupCategory() {
        //1. 查询在架商品
        Wrapper<ProductInfo> queryWrapper=new QueryWrapper<ProductInfo>().lambda().eq(ProductInfo::getProductStatus,ProductStatusEnum.UP);
        List<ProductInfo> productList=this.list(queryWrapper);
        //2. 获取类目type列表
        List<Integer> categoryTypeList = productList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3. 从数据库查询类目
        List<ProductCategory> categoryList=productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductGroupCategoryVO> productVOList = new ArrayList<>();
        for (ProductCategory category: categoryList) {
            List<ProductInfoVO> productInfoList = new ArrayList<>();
            for (ProductInfo productInfo: productList) {
                if (productInfo.getCategoryType().equals(category.getCategoryId())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoList.add(productInfoVO);
                }
            }
            //设置属性值
            ProductGroupCategoryVO productVO = new ProductGroupCategoryVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            productVO.setProductInfoVOList(productInfoList);
            productVOList.add(productVO);
        }
        return productVOList;
    }

    @Override
    public List<ProductInfoDTO> findList(List<String> productIdList) {
        return productInfoDao.selectBatchIds(productIdList).stream().map(product -> {
            ProductInfoDTO output = new ProductInfoDTO();
            BeanUtils.copyProperties(product, output);
            return output;
        }).collect(Collectors.toList());
    }
}
