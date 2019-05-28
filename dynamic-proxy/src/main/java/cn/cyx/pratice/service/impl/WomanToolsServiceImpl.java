package cn.cyx.pratice.service.impl;

import cn.cyx.pratice.service.WomanToolsService;

public class WomanToolsServiceImpl implements WomanToolsService {
    @Override
    public void saleWomanTools(float length) {
        System.out.println("根据需求，定制一个身高" + length + "的男模特");
    }
}
