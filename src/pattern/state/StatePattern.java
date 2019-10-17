package pattern.state;

/**
 * 状态模式(State Pattern) ：允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式。
 * Created by yangb on 2019/10/17
 */
public class StatePattern {

    public static void main(String[] args) {
        ConcreteStateA stateA = new ConcreteStateA();
        Context context = new Context(stateA);
        context.request();
        context.request();
        context.request();
        context.request();
    }
}

class Context{
    State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request(){
        state.handle(this); //对请求做处理并且指向下一个状态
    }

}

interface State{
    void handle(Context context);
}

class ConcreteStateA implements State{

    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());  // 设置A的下一个状态时B
        System.out.println("当前状态是A");
    }
}

class ConcreteStateB implements State{

    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA()); //设置B的下一个状态是A
        System.out.println("当前状态是B");
    }
}
