package com.cyx.project.common.base.dto;

import java.util.List;

public class Page<T> {
    //总记录数
    private int count;
    //数据集
    private List<T> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
