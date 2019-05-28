package cn.cyx.pratice.factory.impl;

import cn.cyx.pratice.factory.ToolsFactory;

public class AaFactory implements ToolsFactory {
    @Override
    public void saleTools(String size) {
        System.out.println("购买一个Size为" + size + "的女模特");
    }
}
