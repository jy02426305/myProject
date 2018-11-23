public class ThreadPractice {
    public static int num;
    public static void main(String[] args) {
        new A().start();
        new B().start();
    }

    public static class A extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <1000 ; i++) {
                num++;
                System.out.println("线程A："+num);
            }
        }
    }

    public static class B extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <1000 ; i++) {
                num++;
                System.out.println("线程B："+num);
            }
        }
    }
}
