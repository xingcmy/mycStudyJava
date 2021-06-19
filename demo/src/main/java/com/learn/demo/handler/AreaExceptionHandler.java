package com.learn.demo.handler;

import com.learn.demo.exception.AreaException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AreaExceptionHandler {

    @ExceptionHandler(value = AreaException.class)
    private Map<String,Object> areaExceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
