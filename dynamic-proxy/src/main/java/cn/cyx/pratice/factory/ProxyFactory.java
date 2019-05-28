package cn.cyx.pratice.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {
    private Object service;

    public void setService(Object service) {
        this.service = service;
    }

    public Object getService() {
        return service;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object result=method.invoke(service,args);
        doSomethingAfter();
        return result;
    }

    private void doSomethingBefore(){
        System.out.println("进行市场调研");
    }
    private void doSomethingAfter(){
        System.out.println("进行精美包装，送货上门服务");
    }
}
