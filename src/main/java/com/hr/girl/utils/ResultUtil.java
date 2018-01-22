package com.hr.girl.utils;

import com.hr.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        return new Result(0,"成功",object);
    }

    public static Result success(){
        return success(null);
    }

    public static Result Error(Integer code,String msg){
        return new Result(code,msg,null);
    }

}
