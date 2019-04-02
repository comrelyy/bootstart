package com.springboot.bootstart.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot全局异常处理，借用了AOP的思想
 */
@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //可以指定异常处理类型
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode","404");
        map.put("errorMsg",e.toString());
        return map;
    }
}
