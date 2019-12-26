package com.example.basegood.entry;


import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProductInfo {
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    private Byte productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";

    public static final String COL_PRODUCT_STOCK = "product_stock";

    public static final String COL_PRODUCT_DESCRIPTION = "product_description";

    public static final String COL_PRODUCT_ICON = "product_icon";

    public static final String COL_PRODUCT_STATUS = "product_status";

    public static final String COL_CATEGORY_TYPE = "category_type";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}