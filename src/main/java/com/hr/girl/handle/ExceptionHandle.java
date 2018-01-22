package com.hr.girl.handle;

import com.hr.girl.domain.Result;
import com.hr.girl.exception.GirlException;
import com.hr.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    private static  final Logger LOGGER = LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.Error(girlException.getCode(),girlException.getMessage());
        }else {
            LOGGER.info("【系统异常】{}",e);  //当捕获到系统异常时日志输出，以便于排错
            return ResultUtil.Error(-1,"未知错误");
        }
    }
}
