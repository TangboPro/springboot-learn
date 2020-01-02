package com.example.servicegood.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.basegood.exception.ProductException;
import com.example.basegood.enums.ProductResultEnum;
import com.example.basegood.enums.ProductStatusEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.basegood.input.DecreaseStockInput;
import com.example.basegood.dto.ProductInfoDTO;
import com.example.basegood.vo.ProductGroupCategoryVO;
import com.example.basegood.vo.ProductInfoVO;
import com.example.basegood.entry.ProductCategory;
import com.example.common.utils.JacksonUtils;
import com.example.servicegood.service.ProductCategoryService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.basegood.entry.ProductInfo;
import com.example.servicegood.dao.ProductInfoDao;
import com.example.servicegood.service.ProductInfoService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService {


    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductGroupCategoryVO> listProductGroupCategory() {
        //1. 查询在架商品
        Wrapper<ProductInfo> queryWrapper = new QueryWrapper<ProductInfo>().lambda().eq(ProductInfo::getProductStatus, ProductStatusEnum.UP);
        List<ProductInfo> productList = this.list(queryWrapper);
        //2. 获取类目type列表
        List<Integer> categoryTypeList = productList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3. 从数据库查询类目
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductGroupCategoryVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            List<ProductInfoVO> productInfoList = new ArrayList<>();
            for (ProductInfo productInfo : productList) {
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

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        //发送mq消息
        List<ProductInfoDTO> productInfoDTOList = productInfoList.stream().map(e -> {
            ProductInfoDTO output = new ProductInfoDTO();
            BeanUtils.copyProperties(e, output);
            return output;
        }).collect(Collectors.toList());
        //mq通知
        amqpTemplate.convertAndSend("productInfo", JacksonUtils.pojoToJson(productInfoDTOList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
            ProductInfo productInfo= productInfoDao.selectById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (productInfo == null) {
                throw new ProductException(ProductResultEnum.PRODUCT_NOT_EXIST);
            }
            //库存是否足够
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ProductResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoDao.updateById(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
