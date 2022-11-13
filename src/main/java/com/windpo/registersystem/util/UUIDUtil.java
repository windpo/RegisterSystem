package com.windpo.registersystem.util;

import java.util.UUID;

/**
 * @author 风之诗
 * @version 1.0
 * 生成随机识别码
 */
public class UUIDUtil {
    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        String uid = id.replaceAll("-", "");
        return uid;
    }
}
