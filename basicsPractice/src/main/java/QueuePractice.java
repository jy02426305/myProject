
import java.util.ArrayDeque;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {

        /*
        queue 先进先出
         */
        Queue<String> queue=new ArrayDeque<String>();
        queue.add("张三");
        queue.add("李四");
        queue.add("王五");
        System.out.println(queue.peek());//检索、但不删除该队列的头部，如果这个队列是空的，则返回null
        System.out.println(queue.poll());//检索并删除该队列的头，如果该队列为空，返回null
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
