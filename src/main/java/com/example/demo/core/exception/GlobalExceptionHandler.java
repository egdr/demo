package com.example.demo.core.exception;

import com.example.demo.core.res.Result;
import com.example.demo.core.res.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.zip.DataFormatException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * http请求的方法不正确
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.error("http请求的方法不正确:【"+e.getMessage()+"】");
        return ResultGenerator.genFailResult("http请求的方法不正确"+e.getMessage());
    }

    /**
     * 请求参数不全
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Result missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.error("请求参数不全:【"+e.getMessage()+"】");
        return ResultGenerator.genFailResult("请求参数不全"+e.getMessage());
    }

    /**
     * 请求参数类型不正确
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public Result typeMismatchExceptionHandler(TypeMismatchException e) {
        log.error("请求参数类型不正确:【"+e.getMessage()+"】");
        return ResultGenerator.genFailResult("请求参数类型不正确"+e.getMessage());
    }

    /**
     * 数据格式不正确
     */
    @ExceptionHandler(DataFormatException.class)
    @ResponseBody
    public Result dataFormatExceptionHandler(DataFormatException e) {
        log.error("数据格式不正确:【"+e.getMessage()+"】");
        return ResultGenerator.genFailResult("数据格式不正确"+e.getMessage());
    }

    /**
     * 非法输入
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Result illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("非法输入:【"+e.getMessage()+"】");
        return ResultGenerator.genFailResult("非法输入"+e.getMessage());
    }


    @ExceptionHandler  //处理其他异常
    @ResponseBody
    public Result allExceptionHandler(Exception e){
        log.error("具体错误信息:【"+e.getMessage()+"】"); //会记录出错的代码行等具体信息
        int count = 0; //只打印15行的错误堆栈
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            log.error(stackTraceElement.toString());
            if(count++ > 13) break;
        }
        return ResultGenerator.genFailResult("其他异常"+e.getMessage());
    }


}
