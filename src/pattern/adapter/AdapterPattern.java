package pattern.adapter;

/**
 * 适配器模式(Adapter Pattern) ：将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 * create by YangBin on 2020/2/5
 * Copyright © 2020 YangBin. All rights reserved.
 */
public class AdapterPattern {

    public static void main(String[] args) {
        Adaptee1 a1 = new Adaptee1(); // 适配者1
        Adaptee2 a2 = new Adaptee2(); // 适配者2

        Adapter adapter = new Adapter(a1); //创建适配器
        adapter.request();

        adapter.setTarget(a2); //更改适配器的适配者
        adapter.request();
    }


}

/**
 * 目标接口
 */
interface Target {
    void request();
}

/**
 * 适配器
 */
class Adapter implements Target{

    private Target target;

    public void setTarget(Target target) {
        this.target = target;
    }

    Adapter(Target target) {
        this.target=target;
    }

    @Override
    public void request() {
        target.request();
    }
}

/**
 * 适配者1
 */
class Adaptee1 implements Target {

    public void request(){
        System.out.println("this is 1 !!!");
    }
}

/**
 * 适配者2
 */
class Adaptee2 implements Target {

    public void request(){
        System.out.println("this is 2 !!!");
    }
}
