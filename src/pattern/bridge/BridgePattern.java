package pattern.bridge;

/**
 * 桥接模式(Bridge Pattern)：将抽象部分与它的实现部分分离，使它们都可以独立地变化。它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式。
 * create by YangBin on 2020/2/5
 * Copyright © 2020 YangBin. All rights reserved.
 */
public class BridgePattern {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementor1());
        abstraction.otherOption();

        abstraction = new RefinedAbstraction(new ConcreteImplementor2());
        abstraction.otherOption();

    }
}

interface Implementor {
    void option();
}

abstract class Abstraction implements Implementor{

    Implementor implementor;

    Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public void option() {
        implementor.option();
    }

    public abstract void otherOption();
}

class ConcreteImplementor1 implements Implementor {

    @Override
    public void option() {
        System.out.println("Implementor do 1");
    }
}

class ConcreteImplementor2 implements Implementor {

    @Override
    public void option() {
        System.out.println("Implementor do 2");
    }
}

class RefinedAbstraction extends Abstraction{

    RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void otherOption() {
        implementor.option();
        System.out.println("other do 1");
    }
}