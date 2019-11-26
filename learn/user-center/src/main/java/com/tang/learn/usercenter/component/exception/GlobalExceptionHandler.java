package com.tang.learn.usercenter.component.exception;

import com.tang.learn.common.api.CommonResult;
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

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public CommonResult globalErrorHandeler(HttpServletRequest req, Exception e) {
        LOGGER.error("全局自定义异常捕获"+e.toString());
        return CommonResult.failed(e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult defalutErrorHandeler(HttpServletRequest req, Exception e){
        LOGGER.error("异常捕获"+e.toString());
        return CommonResult.failed();
    }
    //校验异常
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResult validationErrorHandeler(HttpServletRequest req, Exception e){
        LOGGER.error("异常捕获"+e.toString());
        return CommonResult.failed(e.toString());
    }
}
