package com.cyx.spring.transaction.service;

import java.util.Map;

public interface BookShopService {
    void buyBook();

    void buyBook2(Map<String,Object> map);
}
