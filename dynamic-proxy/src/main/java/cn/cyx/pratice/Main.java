package cn.cyx.pratice;

import cn.cyx.pratice.factory.ProxyFactory;
import cn.cyx.pratice.service.ManToolsService;
import cn.cyx.pratice.service.WomanToolsService;
import cn.cyx.pratice.service.impl.ManToolsServiceImpl;
import cn.cyx.pratice.service.impl.WomanToolsServiceImpl;

public class Main {
    public static void main(String[] args) {
        ManToolsService manToolsService=new ManToolsServiceImpl();
        WomanToolsService womanToolsService=new WomanToolsServiceImpl();

        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setService(manToolsService);
        ManToolsService manToolsProxy= (ManToolsService)proxyFactory.getProxyInstance();
        manToolsProxy.saleManTools("D");

        proxyFactory.setService(womanToolsService);
        WomanToolsService womanToolsProxy= (WomanToolsService)proxyFactory.getProxyInstance();
        womanToolsProxy.saleWomanTools(1.80f);
    }
}
