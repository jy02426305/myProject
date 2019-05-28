package cn.cyx.pratice.service.impl;

import cn.cyx.pratice.service.ManToolsService;

public class ManToolsServiceImpl implements ManToolsService {
    @Override
    public void saleManTools(String size) {
        System.out.println("购买一个Size为" + size + "的女模特");
    }
}
