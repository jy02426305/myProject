package ProxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SingerProxy implements InvocationHandler {
    private Singer singer;
    public SingerProxy(Singer singer){
        this.singer=singer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("请歌手唱歌，需要先交钱");
        method.invoke(singer,args);
        return null;
    }
}
