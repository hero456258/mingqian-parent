package com.mingqian.domain.base;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sum;

    private List<T> data;

    public PageBean() {
    }

    public PageBean(Integer sum, List<T> data) {
        this.sum = sum;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

}
