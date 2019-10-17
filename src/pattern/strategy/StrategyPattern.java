package pattern.strategy;

/**
 * 策略模式
 * 策略模式是一种对象行为型模式。
 * 策略模式(Strategy Pattern)：定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化，也称为政策模式(Policy)。
 * Created by yangb on 2019/10/17
 */
public class StrategyPattern {

    public static void main(String[] args) {
        //策略A
        ConcreteStrategyA strategyA = new ConcreteStrategyA();
        Context contextA = new Context(strategyA);
        contextA.doAction();

        //策略B
        ConcreteStrategyB strategyB = new ConcreteStrategyB();
        Context contextB = new Context(strategyB);
        contextB.doAction();
    }
}

interface Strategy{
    void doAction();
}

class Context implements Strategy {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doAction() {
        this.strategy.doAction();
    }
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void doAction() {
        System.out.println("I am A");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void doAction() {
        System.out.println("I am B");
    }
}