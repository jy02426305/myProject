package com.cyx.project.common.base.dto;

import java.util.List;

public class Page<T> {
    //总记录数
    private int count;
    //数据集
    private List<T> data;
    //当前页
    private int page;
    //每页显示数量
    private int limit;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
