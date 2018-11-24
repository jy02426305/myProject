/**
 * synchronized 关键字，它包括两种用法：synchronized 方法和 synchronized 块
 * 1.当一个线程正在访问一个对象的synchronized方法，那么其他线程不能访问该对象的其他synchronized方法。这个原因很简单，因为一个对象只有一把锁，当一个线程获取了该对象的锁之后，其他线程无法获取该对象的锁，所以无法访问该对象的其他synchronized方法。
 * 2.当一个线程正在访问一个对象的synchronized方法，那么其他线程能访问该对象的非synchronized方法。这个原因很简单，访问非synchronized方法不需要获得该对象的锁，假如一个方法没用synchronized关键字修饰，说明它不会使用到临界资源，那么其他线程是可以访问这个方法的
 * 3.如果一个线程执行一个对象的非static synchronized方法(synchronized方法)，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
 */
public class SynchronizedPractice {
    public int num=1;
    public static int num2=1;

    public void selfAdd(){
        synchronized (this){
            num++;
        }
    }

    public synchronized static void selfAdd2(){
        num2++;
    }

    public static void main(String[] args) throws Exception {
        SynchronizedPractice sync=new SynchronizedPractice();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    sync.selfAdd();
                    SynchronizedPractice.selfAdd2();
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    sync.selfAdd();
                    SynchronizedPractice.selfAdd2();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(sync.num);
        System.out.println(SynchronizedPractice.num2);
        System.out.println("-----------------------------------");

        /**
         * 如果一个线程执行一个对象的非static synchronized方法(synchronized方法)，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
         */
        C c=new C();
        Thread thread3=new Thread(){
            @Override
            public void run() {
                c.jia();
            }
        };

        Thread thread4=new Thread(){
            @Override
            public void run() {
                    C.jian();
            }
        };

        thread3.start();
        thread4.start();

        System.out.println("-----------------------------------");

        /**
         * 当一个线程正在访问一个对象的synchronized方法，那么其他线程不能访问该对象的其他synchronized方法。这个原因很简单，因为一个对象只有一把锁，当一个线程获取了该对象的锁之后，其他线程无法获取该对象的锁，所以无法访问该对象的其他synchronized方法。
         */
        D d=new D();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.aMethod();;
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.bMethod();;
            }
        }).start();
    }
}

/**
 * 如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
 */
class C{
    public int num1=5;
    public int num2=10;

    public synchronized int jia(){
        System.out.println("我进来了jia");
        int temp=0;
        for (int i = 0; i < 100000; i++) {
            num1=num1+i;
            num2=num2+i;
            temp=num1+num2;
        }
        System.out.println("我离开了jia");
        return temp;
    }

    public static synchronized int jian(){
        System.out.println("我进来了jian");
        int temp=0;
        for (int i = 0; i < 100000; i++) {
            temp++;
//            num1=num1+i;
//            num2=num2+i;
//            temp=num2-num1;
        }
        System.out.println("我离开了jian");
        return temp;
    }
}

/**
 * aMethod对象索和bMethod对象索  互斥
 */
class D{
    public synchronized void aMethod(){
        System.out.println("我进来了aMethod");
        int temp=0;
        for (int i = 0; i < 10000; i++) {
            temp++;
        }
        System.out.println("我离开了aMethod");
    }

    public synchronized void bMethod(){
        System.out.println("我进来了bMethod");
        int temp=0;
        for (int i = 0; i < 10000; i++) {
            temp++;
        }
        System.out.println("我离开了bMethod");
    }
}