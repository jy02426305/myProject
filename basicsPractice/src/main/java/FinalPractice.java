public class FinalPractice {
    public final int num = 1;
    public final String[] strAry = {"你好", "我好", "大家好"};
    public final Boolean flag;

    /*
    final修饰一个成员变量（属性），必须要显示初始化。这里有两种初始化方式，一种是在变量声明的时候初始化；第二种方法是在声明变量的时候不赋初值，但是要在这个变量所在的类的所有的构造函数中对这个变量赋初值。
     */
    public FinalPractice(){
        flag=false;
    }


    public static void main(String[] args) {
        FinalPractice finalPractice = new FinalPractice();
        //region final修饰变量
        /*
        当final修饰一个基本数据类型时，表示该基本数据类型的值一旦在初始化后便不能发生变化；如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了，但该引用所指向的对象的内容是可以发生变化的。本质上是一回事，因为引用的值是一个地址，final要求值，即地址的值不发生变化。
         */
//        finalPractice.num=2;
        finalPractice.strAry[0] = "广州好迪";
        System.out.println(finalPractice.strAry[0]);
        //endregion

        FinalInner2Class inner2 = new FinalInner2Class();
        inner2.say("喵喵喵");

        FinalInner3Class inner3=new FinalInner3Class();
        System.out.println(inner3.jia());

        FinalInner1Class inner1=new FinalInner1Class();
        inner1.world="hello";
        finalPractice.print(inner1);
        System.out.println(inner1.world);
    }

    public void print(FinalInner1Class inner){
        inner.world=inner.world+" world";
    }

}

class FinalInner1Class {
    public String world;

    public final void say() {
        System.out.println("hello");
    }

    public int jia(final int num){
//        num=num+1;//被final修饰的形参，不能再修改
        return num+2;
    }
}


class FinalInner2Class extends FinalInner1Class {
    /*
    不能重写
     */
//    public void say(){
//        System.out.println("yes");
//    }

    /*
    可以重载
     */
    public void say(String word) {
        System.out.println(word);
    }
}

final class FinalInner3Class{
    public int num1;

    public int jia(){
        num1=5;
        return num1+2;
    }
}