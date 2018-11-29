public class CutMemoryPractice {
    public static void main(String[] args) {
        Person person=new Person();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {

            person.setAge(18);
            person.setIdCard("350502198806111030");
            person.setName("张三");
            person.setSex("男");
        }
        long end=System.currentTimeMillis();
        System.out.println((end - start));
    }
}
