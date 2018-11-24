import java.util.*;

/**
 * 双向队列
 */
public class DequePractice {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("张三");//调用offerLast
        deque.offerLast("李四");//调用addLast
        deque.add("王五");//调用addLast
        deque.push("刘二");//调用addFirst
        deque.push("李一");
        System.out.println(deque.peek());
        System.out.println(deque.poll());//==removeFirst==pollFirst
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println("---------------------------------------------------");
        Deque<String> deque2 = new ArrayDeque<>();
        deque2.addFirst("张三");
        deque2.addFirst("李四");
        deque2.addFirst("王五");
        deque2.addLast("刘二");
        deque2.addLast("李一");
        for (String s : deque2) {
            System.out.println(s);
        }

//        // 通过Iterator遍历LinkedList
//        iteratorDequeThruIterator(getDeque());
//
//        // 通过快速随机访问遍历LinkedList
//        iteratorDequeThruForeachFirst(getDeque());
//
//        iteratorDequeThruForeachLast(getDeque());
//
//        // 通过for循环的变种来访问遍历LinkedList
//        iteratorThroughFor2(getDeque());
//
//        // 通过PollFirst()遍历LinkedList
//        iteratorThroughPollFirst(getDeque());
//
//        // 通过PollLast()遍历LinkedList
//        iteratorThroughPollLast(getDeque());
//
//        // 通过removeFirst()遍历LinkedList
//        iteratorThroughRemoveFirst(getDeque());
//
//        // 通过removeLast()遍历LinkedList
//        iteratorThroughRemoveLast(getDeque());
    }

    private static Deque getDeque() {
        Deque llist = new ArrayDeque();
        for (int i = 0; i < 1000000; i++)
            llist.addLast(i);

        return llist;
    }

    /**
     * 通过快迭代器遍历Deque
     */
    private static void iteratorDequeThruIterator(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();

        for (Iterator iter = list.iterator(); iter.hasNext(); )
            iter.next();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorDequeThruIterator：" + interval + " ms");
    }

    /**
     * 通过快速随机访问遍历Deque
     */
    private static void iteratorDequeThruForeachFirst(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.getFirst();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorDequeThruForeachFirst：" + interval + " ms");
    }

    /**
     * 通过快速随机访问遍历Deque
     */
    private static void iteratorDequeThruForeachLast(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.getLast();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorDequeThruForeachLast：" + interval + " ms");
    }

    /**
     * 通过另外一种for循环来遍历Deque
     */
    private static void iteratorThroughFor2(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();

        for (Integer integ : list)
            ;

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughFor2：" + interval + " ms");
    }

    /**
     * 通过pollFirst()来遍历Deque
     */
    private static void iteratorThroughPollFirst(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollFirst() != null)
            ;

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollFirst：" + interval + " ms");
    }

    /**
     * 通过pollLast()来遍历Deque
     */
    private static void iteratorThroughPollLast(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollLast() != null)
            ;

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollLast：" + interval + " ms");
    }

    /**
     * 通过removeFirst()来遍历Deque
     */
    private static void iteratorThroughRemoveFirst(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeFirst() != null)
                ;
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveFirst：" + interval + " ms");
    }

    /**
     * 通过removeLast()来遍历Deque
     */
    private static void iteratorThroughRemoveLast(Deque<Integer> list) {
        if (list == null)
            return;

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeLast() != null)
                ;
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveLast：" + interval + " ms");
    }
}
