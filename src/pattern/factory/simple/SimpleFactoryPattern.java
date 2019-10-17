package pattern.factory.simple;

/**
 * 简单工厂模式(Simple Factory Pattern)：又称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 * Created by yangb on 2019/10/17
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Product a = factory.createProduct("A");
        a.use();
        Product b = factory.createProduct("B");
        b.use();
    }
}

interface Product{
    void use();
}

class ConcreteProductA implements Product{

    @Override
    public void use() {
        System.out.println("A 产品");
    }
}

class ConcreteProductB implements Product{

    @Override
    public void use() {
        System.out.println("B 产品");
    }
}

class Factory {

    public Product createProduct(String productName){
        if(productName.equals("A")){
            return new ConcreteProductA();
        }else if(productName.equals("B")) {
            return new ConcreteProductB();
        }
        return null;
    }
}
