package cn.cyx.pratice.proxy;

import cn.cyx.pratice.factory.ToolsFactory;

public class LisonProxy implements ToolsFactory {
    private ToolsFactory toolsFactory;
    public LisonProxy(ToolsFactory toolsFactory){
        super();
        this.toolsFactory=toolsFactory;
    }
    @Override
    public void saleTools(String size) {
        doSomethingBefore();
        toolsFactory.saleTools(size);
        doSomethingAfter();
    }

    private void doSomethingBefore(){
        System.out.println("进行市场调研");
    }
    private void doSomethingAfter(){
        System.out.println("进行精美包装，送货上门服务");
    }
}
