package com.mingqian.domain.base;

import java.util.List;

public class PageBeanUtils {

    public static <T> PageBean<T> make(List<T> result, Integer sum){
        return new PageBean(sum,result);
    }
}
