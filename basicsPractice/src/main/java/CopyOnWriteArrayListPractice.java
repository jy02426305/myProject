import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*

 */
public class CopyOnWriteArrayListPractice {
    public static CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<Integer> list2=new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
//        new FailFastPractice.B().start();
//        new FailFastPractice.A().start();

        CopyOnWriteArrayListPractice copyOnWriteArrayListPractice=new CopyOnWriteArrayListPractice();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    copyOnWriteArrayListPractice.list2.add(i);
                }
                String put="";
                int len=copyOnWriteArrayListPractice.list2.size();
                for (int i = 0; i <len; i++) {
                    put+=copyOnWriteArrayListPractice.list2.get(i)+",";
                }
                System.out.println(put);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    copyOnWriteArrayListPractice.list2.add(i);
                }
                String put="";
                for (int i = 0,len=copyOnWriteArrayListPractice.list2.size(); i <len; i++) {
                    put+=copyOnWriteArrayListPractice.list2.get(i)+",";
                }
                System.out.println(put);
            }
        }).start();
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
                Iterator<Integer> itr=list.iterator();//迭代操作，对itr操作，会"同步"到list
                while(itr.hasNext()){
                    System.out.print(itr.next()+"，");//必须有.next()操作，使cursor和lastRet分别+1，不然会死循环
                }
                i++;
            }
        }
    }
}
