package com.hr.girl.handle;

import com.hr.girl.domain.Result;
import com.hr.girl.exception.GirlException;
import com.hr.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.Error(girlException.getCode(),girlException.getMessage());
        }else {
            return ResultUtil.Error(-1,"未知错误");
        }
    }
}
