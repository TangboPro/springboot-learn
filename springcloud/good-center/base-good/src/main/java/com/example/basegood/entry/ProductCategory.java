package com.example.basegood.entry;

import java.util.Date;

import lombok.Data;

@Data
public class ProductCategory {
    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

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

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_CATEGORY_NAME = "category_name";

    public static final String COL_CATEGORY_TYPE = "category_type";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}