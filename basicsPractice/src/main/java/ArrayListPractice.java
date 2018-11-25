import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList 练习
 */
public class ArrayListPractice {
    public static void main(String[] args) {
        List<Integer> intList=new ArrayList<Integer>(5);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        Integer[] integerAry= intList.toArray(new Integer[0]);
        for (Integer integer : integerAry) {
            System.out.println(integer);
        }
        /*
        下面代码执行会报ConcurrentModificationException，详情原因看https://www.cnblogs.com/dolphin0520/p/3933551.html
         */
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer integer = iterator.next();
//            if(integer==2)
//                list.remove(integer);
//        }
    }
}
