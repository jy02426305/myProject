package cn.cyx.pratice.factory.impl;

import cn.cyx.pratice.factory.ToolsFactory;

public class BbFactory implements ToolsFactory {
    @Override
    public void saleTools(String size) {
        System.out.println("根据需求，定制一个身高" + size + "的男模特");
    }
}
