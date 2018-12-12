package gcTest;

public class gcMain {
    public static Person person;
    static {
        person=new Person();
    }
    public static void main(String[] args) {
        person.setName("张三");
        person.setSex("男");
        System.out.println(person.getName());
        System.gc();
    }
}
