package com.example.baseorder.exception;

import com.example.baseorder.resultcode.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = OrderException.class)
    @ResponseBody
    public BaseResult orderErrorHandeler(HttpServletRequest req, Exception e) {
        LOGGER.error("订单异常捕获" + e.toString());
        return BaseResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult defalutErrorHandeler(HttpServletRequest req, Exception e) {
        LOGGER.error("异常捕获" + e.toString());
        return BaseResult.failed();
    }

    //校验异常
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public BaseResult validationErrorHandeler(HttpServletRequest req, Exception e) {
        LOGGER.error("校验异常捕获" + e.toString());
        return BaseResult.failed(e.toString());
    }
}
