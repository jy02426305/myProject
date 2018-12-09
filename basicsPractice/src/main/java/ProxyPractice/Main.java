package ProxyPractice;

import java.lang.reflect.Proxy;

/*
动态代理
 */
public class Main {
    public static void main(String[] args) {
        Singer singer=new Liudehua();
        SingerProxy singerProxy=new SingerProxy(singer);
        Singer singer2= (Singer) Proxy.newProxyInstance(singerProxy.getClass().getClassLoader(),singer.getClass().getInterfaces(),singerProxy);
        singer2.sing("冰雨");
    }
}
