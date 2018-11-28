package com.cyx.spring.service.impl;

import com.cyx.spring.service.BookService;
import org.springframework.stereotype.Service;

@Service(value="novelBookService")
public class NovelBookServiceImpl implements BookService {
    private String name;
    private double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
