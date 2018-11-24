/**
 * 未能验证volatile有序性
 */
public class VolatilePractice {
    public static Person person;
    public volatile static Boolean next=false;
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                person = new Person();
                for (int i = 0; i < 10000; i++) {
                    if (i == 9999) {
                        person.setName("张三");
                    }
                }
                next = true;
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                int j=0;
                while(!next){
                    j++;
//                    System.out.println("如果线程1不给next赋值完，就不停下来。");
                }
                System.out.println(j);
                System.out.println("我的名字叫"+(person==null?"无名": person.getName())+"，总能在线程1为next赋值之后输出");
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
