package pattern.factory.method;

/**
 * 工厂方法模式(Factory Method Pattern)又称为工厂模式，也叫虚拟构造器(Virtual Constructor)模式或者多态工厂(Polymorphic Factory)模式，它属于类创建型模式。
 * 在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
 * Created by yangb on 2019/10/17
 */
public class FactoryMethodPattern {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        Product product = factory.factoryMethod();
        product.use();
    }
}

interface Factory{
    Product factoryMethod();
}

interface Product{
    void use();
}

class ConcreteProductA implements Product {

    @Override
    public void use() {
        System.out.println("A 产品");
    }
}

class ConcreteProductB implements Product {

    @Override
    public void use() {
        System.out.println("B 产品");
    }
}

class ConcreteFactoryA implements Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteFactoryB implements Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}