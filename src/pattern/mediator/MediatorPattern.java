package pattern.mediator;

import java.util.Map;
import java.util.TreeMap;

/**
 * 中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 * Created by yangb on 2019/10/17
 */
public class MediatorPattern {

    public static void main(String[] args) {
        ConcreteColleagueA A = new ConcreteColleagueA();
        ConcreteColleagueB B = new ConcreteColleagueB();
        Mediator mediator = new Mediator();
        mediator.register("A",A);
        mediator.register("B",B);

        // 直接通过中介者给A发消息
        mediator.operation("A","你好啊A, 猜猜我是谁!");

        // A在内部发送消息给B
        A.send();
    }
}

// 中介类
class Mediator{
    Map<String, Colleague> map = new TreeMap<>();

    void operation(String key, String msg){
        map.get(key).receive(msg);
    }
    void register(String key, Colleague colleague){
        map.put(key, colleague);
        colleague.setMediator(this);
    }
}

interface Colleague{
    void receive(String msg);
    void send();
    void setMediator(Mediator mediator);
}

class ConcreteColleagueA implements Colleague{
    private Mediator mediator;
    @Override
    public void receive(String msg) {
        System.out.println("接收人:A 消息内容:" + msg);
    }

    @Override
    public void send() {
        mediator.operation("B","你好B,我是A");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ConcreteColleagueB implements Colleague{
    private Mediator mediator;
    @Override
    public void receive(String msg) {
        System.out.println("接收人:B 消息内容:" + msg);
    }

    @Override
    public void send() {
        mediator.operation("A","你好A, 我是B");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}


