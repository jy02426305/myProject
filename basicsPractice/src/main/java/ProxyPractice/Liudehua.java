package ProxyPractice;

public class Liudehua implements Singer{
    @Override
    public void sing(String song){
        System.out.println("刘德华演唱了一首《" + song + "》");
    }
}
