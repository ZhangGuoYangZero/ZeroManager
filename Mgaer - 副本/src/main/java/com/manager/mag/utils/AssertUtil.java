package com.manager.mag.utils;

import com.manager.mag.exceptions.ParamsException;

public class AssertUtil {


    public  static void isTrue(Boolean flag,String msg){
        if(flag){
            throw  new ParamsException(msg);
        }
    }

}
