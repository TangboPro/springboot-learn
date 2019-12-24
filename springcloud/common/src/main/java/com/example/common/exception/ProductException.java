package com.example.common.exception;

import com.example.common.resultcode.enums.ProductResultEnum;

/**
 * 产品服务异常
 */
public class ProductException extends RuntimeException {
    public ProductException(ProductResultEnum resultEnum) {
        super(resultEnum.getMessage());
    }
}
