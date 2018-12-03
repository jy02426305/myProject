import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorPractice {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask=new MyTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("---------------------------------");
            System.out.println("线程池核心线程数：" + threadPoolExecutor.getCorePoolSize() + "，线程池中总线程数：" + threadPoolExecutor.getPoolSize());
            System.out.println("队列中等待线程数：" + threadPoolExecutor.getQueue().size() + "，已执行完线程数：" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}

class MyTask implements Runnable{
    private int i;
    public MyTask(int i){
        this.i=i;
    }

    @Override
    public void run(){
        System.out.println("正在执行task：" + i);
        try{
            Thread.currentThread().sleep(2000);
        }catch (Exception ex){}
        System.out.println("task" + i + "执行完毕");
    }
}
