package com.hspedu.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class DataUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
