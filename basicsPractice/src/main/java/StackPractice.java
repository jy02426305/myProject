import java.util.Collections;
import java.util.Stack;

/*
栈
 */
public class StackPractice {
    public static void main(String[] args) {
        /*
        先进后出，官方推荐使用Deque（双端队列）的实现代替Stack
         */
        Stack<String> stack=new Stack<String>();
        stack.push("张三");
        stack.push("李四");
        stack.push("王五");
        System.out.println(stack.peek());//查看栈顶部对象，而不移除他
        System.out.println(stack.pop());//移除堆栈顶部的对象并返回该对象，对象作为此函数的值

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
