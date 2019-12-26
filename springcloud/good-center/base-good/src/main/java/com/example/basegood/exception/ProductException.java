package com.example.basegood.exception;


import com.example.basegood.enums.ProductResultEnum;

/**
 * 产品服务异常
 */
public class ProductException extends RuntimeException {
    public ProductException(ProductResultEnum resultEnum) {
        super(resultEnum.getMessage());
    }
}
