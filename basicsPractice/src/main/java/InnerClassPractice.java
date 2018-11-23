import java.awt.image.ImageProducer;

/**
 * 匿名内部类
 */
public class InnerClassPractice {

    public static void main(String[] args) {
        //region 声明非静态内部类
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass innerClass = outer.new InnerClass();
        innerClass.say();
        //endregion

        //region 声明静态内部类
        OuterClass.InnerClass2 innerClass2 = new OuterClass.InnerClass2();
        innerClass2.say();
        //endregion
        outer.testMethod2();
    }
}

class OuterClass {
    private String name = "张三";
    public String phone = "18900392517";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void testMethod() {
        OuterClass o = new OuterClass();
        System.out.println(o.name);
    }

    public void testMethod2() {
        new InnerClass().say();
    }


    public class InnerClass {
        //        private static int num=30;//报错，在成员内部类中不能声明静态属性和方法
        private final int num2 = 20;
        private final static int num3 = 10;

        public void say() {
            System.out.println("我的名字叫"+OuterClass.this.getName());
        }

        public void buy() {
            //1.8以前写法 final String product="包包";
            String product = "包包";
            class InnerClass3 {
                public void go(){
                    System.out.println("去买"+product);
                }
            }
        }
    }

    public static int num4=50;
    public static class InnerClass2 {

        public void say() {
//            System.out.println(OuterClass.this.name);//静态内部类不能访问外部类的非静态成员
            System.out.println(OuterClass.num4);
            System.out.println("你好");
        }
    }
}