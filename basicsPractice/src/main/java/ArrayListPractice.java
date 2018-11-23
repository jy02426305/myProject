import java.util.ArrayList;
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
    }
}
