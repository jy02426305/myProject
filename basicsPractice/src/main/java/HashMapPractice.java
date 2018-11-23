import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        /*
        hashmap是数组+链表+红黑树(jdk8)结构
        一个元素(entry)包含：hashcode、key、value、next（指向下一个entry）
         */
        Map<Integer,String> map=new HashMap();
        map.put(1,"张三");
        map.put(2,"李四");
    }
}
