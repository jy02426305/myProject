import javafx.animation.Animation;

public class VolatilePractice {
    public static Person person;
    public static Boolean next=false;
    public static int a=10;
    public volatile static int b=11;
    public static int c=12;
    public static int d=13;
    public static int e=14;
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                person=new Person();
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        person.setName("张三");
                    }
                }
                next=true;
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        a=2;
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        b=3;
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        c=4;
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        d=5;
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    if(i==999){
                        e=6;
                    }
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!next){
                    System.out.println("如果线程1不给next赋值完，就不停下来。");
                }
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(d);
                System.out.println(e);
                System.out.println("我的名字叫"+person.getName()+"，总能在线程1为next赋值之后输出");
            }
        });

        thread2.start();
        thread1.start();

//        A a=new A();
//        a.thread2.start();
//        a.thread1.start();
    }
}

class A{
    int x=3;
    int y=4;
    Boolean flag=true;
    Thread thread1=new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if(i==999){
                    x=-3;
                    y=-4;
                }
            }
            flag=false;
        }
    });
    Thread thread2=new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(x);
            System.out.println(y);
            System.out.println(flag);
        }
    });
}
