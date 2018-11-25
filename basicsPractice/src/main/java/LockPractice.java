import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPractice {
    private int num;
    private static int num2;
    ReentrantLock lock=new ReentrantLock(true);//设置为公平索，//等待最久的线程，会先获得索

    public static void main(String[] args) {
        LockPractice lockPractice=new LockPractice();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockPractice.selfAdd(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockPractice.selfAdd(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("-------------------------------------");

        LockPractice lockPractice2=new LockPractice();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockPractice2.selfAdd2(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockPractice2.selfAdd2(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("-----------------------------------------------------");

        LockPractice lockPractice3=new LockPractice();
        Thread thread4= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lockPractice3.selfAdd3(Thread.currentThread());
                }catch (Exception ex){
                    System.out.println(Thread.currentThread().getName()+ "异常");
                }
            }
        });
        thread4.start();
//        thread4.interrupt();
//        System.out.println(LockPractice.num2);

        Thread thread5=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockPractice3.selfAdd3(Thread.currentThread());
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+ "异常");
                }
            }
        });
        thread5.start();
    }

    public void selfAdd(Thread thread) throws InterruptedException{
        lock.lock();
        try{
            System.out.println(thread.getName()+"获得锁");
            Thread.sleep(2000);
        }finally {
            System.out.println(thread.getName()+"释放锁");
            lock.unlock();
        }
        return;
    }

    public void selfAdd2(Thread thread) throws InterruptedException{
        if(lock.tryLock()){
            System.out.println(thread.getName() + "获得锁");
            try{
                Thread.sleep(2000);
            }finally {
                System.out.println(thread.getName() + "释放锁");
                lock.unlock();
            }
        }else{
            System.out.println(thread.getName()+"获取锁失败");
            thread.interrupt();//interrupt()只会中断被阻塞的线程
            System.out.println(thread.getName()+"中断线程");
        }
    }

    /*
    lockInterruptibly()方法比较特殊，当通过这个方法去获取锁时，如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。也就使说，当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，假若此时线程A获取到了锁，而线程B只有在等待，那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
    由于lockInterruptibly()的声明中抛出了异常，所以lock.lockInterruptibly()必须放在try块中或者在调用lockInterruptibly()的方法外声明抛出InterruptedException。
     */
    public void selfAdd3(Thread thread) throws InterruptedException{
        System.out.println(thread.getName() + "请求索");
        if(!lock.isHeldByCurrentThread()){
            System.out.println(thread.getName() + "未获得锁，执行中断");
            thread.interrupt();
        }
        lock.lockInterruptibly();
        System.out.println(thread.getName() + "获得锁");
        try{
            thread.sleep(5000);
        }finally {
            System.out.println(thread.getName() + "释放锁");
            lock.unlock();
        }
    }


}
