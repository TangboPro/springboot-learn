package com.example.serviceorder.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Classname OrderDetail
 * @Description TODO
 * @Date 2019/12/26 21:51
 * @author tang
 */
@Data
@TableName(value = "order_detail")
public class OrderDetail {
    @TableId(value = "detail_id", type = IdType.INPUT)
    private String detailId;

    @TableField(value = "order_id")
    private String orderId;

    @TableField(value = "product_id")
    private String productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 当前价格,单位分
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 数量
     */
    @TableField(value = "product_quantity")
    private Integer productQuantity;

    /**
     * 小图
     */
    @TableField(value = "product_icon")
    private String productIcon;

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

    public static final String COL_DETAIL_ID = "detail_id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";

    public static final String COL_PRODUCT_QUANTITY = "product_quantity";

    public static final String COL_PRODUCT_ICON = "product_icon";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}