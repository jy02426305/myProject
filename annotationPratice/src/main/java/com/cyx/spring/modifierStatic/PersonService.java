package com.cyx.spring.modifierStatic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service(value="lazyPersonService")
@Lazy(value=true)
public class PersonService {
    public final int var1=1;
    public final int[] ary1=new int[5];
    public final Man man=new Man();
    
    /*
    类装载后执行
     */
    public PersonService(){
        System.out.println("loading constructor for lazy class");
        System.out.println(var1);
    }

    /*
    类装载后分配内存
     */
    public static void say(){
        System.out.println("call static method in lazy class...");
    }
}
