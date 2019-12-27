package com.example.basegood.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
@TableName(value = "product_info")
public class ProductInfo {
    @TableId(value = "product_id", type = IdType.INPUT)
    private String productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 单价
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @TableField(value = "product_stock")
    private Integer productStock;

    /**
     * 描述
     */
    @TableField(value = "product_description")
    private String productDescription;

    /**
     * 小图
     */
    @TableField(value = "product_icon")
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    @TableField(value = "product_status")
    private Byte productStatus;

    /**
     * 类目编号
     */
    @TableField(value = "category_type")
    private Integer categoryType;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
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
