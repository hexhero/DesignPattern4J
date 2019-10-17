package observer.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式(Observer Pattern)：定义对象间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。观察者模式又叫做发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。
 * 观察者模式是一种对象行为型模式。
 * Created by yangb on 2019/10/17
 */
public class ObserverPattern {

    public static void main(String[] args) {
        ObserverA observerA = new ObserverA();
        ObserverB observerB = new ObserverB();
        Subject subject = new Subject();
        subject.subscribe(observerA);
        subject.subscribe(observerB);
        subject.process();
    }
}

// 观察的目标
class Subject{
    List<Observer> observers = new ArrayList<>();
    //订阅
    public boolean subscribe(Observer observer){
        return observers.add(observer);
    }
    //取消订阅
    public boolean unsubscribe(Observer observer){
        return observers.remove(observer);
    }

    public void process(){
        int i = 0;
        while (true){
            i++;
            for (Observer observer : observers) {
                observer.notify(i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

interface Observer{
    void notify(int i);
}

class ObserverA implements Observer{

    @Override
    public void notify(int i) {
        System.out.println("A订阅数据: " + i);
    }
}

class ObserverB implements Observer{

    @Override
    public void notify(int i) {
        System.out.println("B订阅数据: " + i);
    }
}


