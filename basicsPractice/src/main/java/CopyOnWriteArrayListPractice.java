import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*

 */
public class CopyOnWriteArrayListPractice {
    public static CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
        new FailFastPractice.B().start();
        new FailFastPractice.A().start();
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
