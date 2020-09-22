package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>异常处理类
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.controller.BaseExceptionHandler.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年09月22日 10:09
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
