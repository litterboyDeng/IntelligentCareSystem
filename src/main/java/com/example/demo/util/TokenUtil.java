package com.example.demo.util;

import java.util.UUID;

/**
 * @ClassName TokenUtils
 * @Description token生成工具类
 * @Created by dengzhiwen
 * @Date 2020/6/29 18:40
 **/
public class TokenUtil {

    public static String getToken(){
        return UUID.randomUUID().toString();
    }
}
