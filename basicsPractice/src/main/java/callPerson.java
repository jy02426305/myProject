public class callPerson {
    public static void main(String[] args) throws ClassNotFoundException{
        //initialize，该类是否必须被初始化
        Class person= Class.forName("Person",true,ClassLoader.getSystemClassLoader());
        System.out.println(person.getName() + "," + person.getSimpleName());

//        Class person2 =ClassLoader.getSystemClassLoader().loadClass("Person");
//        System.out.println(person2.getName() + "," + person2.getSimpleName());

    }
}
