package cn.cyx.pratice;

import cn.cyx.pratice.factory.WomanToolsFactory;
import cn.cyx.pratice.factory.impl.AaFactory;
import cn.cyx.pratice.factory.impl.BbFactory;
import cn.cyx.pratice.proxy.LisonProxy;
import cn.cyx.pratice.factory.ToolsFactory;

public class Main {
    public static void main(String[] args) {
        ToolsFactory factory=new AaFactory();
        LisonProxy lisonProxy=new LisonProxy(factory);
        lisonProxy.saleTools("D");

        ToolsFactory factory2=new BbFactory();
        LisonProxy lisonProxy1=new LisonProxy(factory2);
        lisonProxy1.saleTools("1.80");
    }
}
