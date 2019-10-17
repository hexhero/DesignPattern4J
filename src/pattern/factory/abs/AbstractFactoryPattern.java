package pattern.factory.abs;

/**
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 * Created by yangb on 2019/10/17
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        AbstractFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("Rectangle");
        shape.draw();

        factory = new ColorFactory();
        Color red = factory.getColor("red");
        red.fill();

    }

}

interface Shape{
    void draw();
}

class RectangleShape implements Shape{

    @Override
    public void draw() {
        System.out.println("画 矩形");
    }
}

class CircleShape implements Shape{

    @Override
    public void draw() {
        System.out.println("画 圆形");
    }
}

interface Color{
    void fill();
}

class Red implements Color{
    @Override
    public void fill() {
        System.out.println("红色");
    }
}

class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("蓝色");
    }
}

abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);

}

class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if(shape.equals("Rectangle")){
            return new RectangleShape();
        }else if(shape.equals("Circle")){
            return new CircleShape();
        }
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        if(color.equals("red")){
            return new Red();
        } else if (color.equals("blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}