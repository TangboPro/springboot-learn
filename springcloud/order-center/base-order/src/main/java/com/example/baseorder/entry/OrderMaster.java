package com.example.baseorder.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Classname OrderMaster
 * @Description TODO
 * @Date 2019/12/26 21:51
 * @author tang
 */
@Data
@TableName(value = "order_master")
public class OrderMaster {
    @TableId(value = "order_id", type = IdType.INPUT)
    private String orderId;

    /**
     * 买家名字
     */
    @TableField(value = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @TableField(value = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @TableField(value = "buyer_address")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @TableField(value = "buyer_openid")
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    @TableField(value = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为新下单
     */
    @TableField(value = "order_status")
    private int orderStatus;

    /**
     * 支付状态, 默认未支付
     */
    @TableField(value = "pay_status")
    private int payStatus;

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

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_BUYER_NAME = "buyer_name";

    public static final String COL_BUYER_PHONE = "buyer_phone";

    public static final String COL_BUYER_ADDRESS = "buyer_address";

    public static final String COL_BUYER_OPENID = "buyer_openid";

    public static final String COL_ORDER_AMOUNT = "order_amount";

    public static final String COL_ORDER_STATUS = "order_status";

    public static final String COL_PAY_STATUS = "pay_status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}