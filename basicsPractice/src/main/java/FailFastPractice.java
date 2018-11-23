import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 多线程同时修改同一个ArrayList对象，当A线程对ArrayList进行插入/删除操作modCount会+1，此时B线程去操作ArrayList对象，则expectedModCount != modCount会抛出java.util.ConcurrentModificationException异常
 */
public class FailFastPractice {
    public static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        new B().start();
        new A().start();
    }

    public static class A extends Thread{
        @Override
        public void run() {
            int i=0;
            while (i<6){
                System.out.println("");
                list.add(i);
                Iterator<Integer> itr=list.iterator();
                while(itr.hasNext()){
                    System.out.print(itr.next()+"，");
                }
                i++;
            }
        }
    }
    public static class B extends Thread{
        @Override
        public void run() {
            int i=0;
            while(i<10){
                System.out.println("");
                list.add(i);
                Iterator<Integer> itr=list.iterator();
                while(itr.hasNext()){
                    System.out.print(itr.next()+"，");
                }
                i++;
            }
        }
    }
}
