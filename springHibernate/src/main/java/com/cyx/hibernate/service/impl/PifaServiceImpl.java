package com.cyx.hibernate.service.impl;

import com.cyx.hibernate.service.BookShopService;
import com.cyx.hibernate.service.PifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "pifaService")
public class PifaServiceImpl implements PifaService {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void buyBooks() {
        bookShopService.buyBook("论语", 1, "张三");
        bookShopService.buyBook("百年孤独", 2, "张三");
    }
}
