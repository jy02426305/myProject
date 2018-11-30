public class JvmMethodAreaPractice {
    public static void main(String[] args) {
        String str1="aaa";//在方法区 常量池
        String str2="aaa";//在方法区 常量池
        System.out.println(str1 == str2);//都指向方法区 常量池，为true

        String str3=new String("bbb");//在堆
        String str4=new String("bbb");//在堆
        System.out.println(str3== str4);//不同内存空间，==运算为false
    }
}
