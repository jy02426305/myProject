public class SingletonPracticeTest {
    public static void main(String[] args) {
        SingletonPractice singletonPractice1=SingletonPractice.getInstance();
        SingletonPractice singletonPractice2=SingletonPractice.getInstance();
        System.out.println(singletonPractice1 == singletonPractice2);
    }
}
