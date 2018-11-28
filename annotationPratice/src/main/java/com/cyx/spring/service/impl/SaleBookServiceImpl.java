package com.cyx.spring.service.impl;

import com.cyx.spring.service.BookService;

public class SaleBookServiceImpl extends NovelBookServiceImpl implements BookService {
    private double salePrice;

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
