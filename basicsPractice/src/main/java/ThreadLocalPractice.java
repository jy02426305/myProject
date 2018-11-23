public class ThreadLocalPractice {
    private ThreadLocal<String> qq=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "14038796";
        }
    };

    public void setQq(String qq) {
        this.qq.set(qq);
    }

    public String getQq(){
        return this.qq.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalPractice tl=new ThreadLocalPractice();

//        tl.setQq("14038796");
        System.out.println("主线程："+tl.getQq());

        Thread one=new Thread(){
            @Override
            public void run() {
                tl.setQq("88042711");
                System.out.println("子线程："+tl.getQq());
            }
        };
        one.start();
        one.join();//使父线程(main)等待子线程执行结束再继续执行

        System.out.println("主线程："+tl.getQq());
    }
}
