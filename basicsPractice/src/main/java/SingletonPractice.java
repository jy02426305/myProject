public class SingletonPractice {
    private volatile static SingletonPractice instance;
    private SingletonPractice(){}

    public static SingletonPractice getInstance(){
        if(instance==null){
            synchronized (SingletonPractice.class){
                if(instance==null){
                    instance=new SingletonPractice();
                }
            }
        }
        return instance;
    }
}
