package com.fluentcommerce.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

public class Guard {
    public static void requireNotNullString(String str){
        if(StringUtils.isBlank(str))
            throw new NullPointerException();
    }

    public static void requireNotNullString(String str, String message){
        if(StringUtils.isBlank(str))
            throw new NullPointerException(message);
    }

    public static void requireNotNull(Object object) {
        if(object == null)
            throw new NullPointerException();
    }

    public static void requireNotNull(Object object, String message) {
        if(object == null)
            throw new NullPointerException(message);
    }


    public static void requireNotNullOrEmptyList(List list){
        requireNotNull(list);
        if(list.isEmpty())
            throw new NullPointerException();
    }

    public static void requireNotNullOrEmptySet(Set set){
        requireNotNull(set);
        if(set.isEmpty())
            throw new NullPointerException();
    }

    public static  <T extends RuntimeException> void requireNotNull(Object object, T clazz) {
        if(object == null)
            throw clazz;
    }
}
