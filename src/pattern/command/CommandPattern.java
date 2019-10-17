package pattern.command;

/**
 * 命令模式（Command Pattern）请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 * >
 * Created by yangb on 2019/10/17
 */
public class CommandPattern {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);

        invoker.action();
    }
}

// 接收命令并执行
class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}

interface Command{
    void execute();
}

// 业务动作
class Receiver {
    void processA(){
        System.out.println("步骤A");
    }
    void processB(){
        System.out.println("步骤B");
    }
}

class ConcreteCommand implements Command{

    private Receiver recever;

    public ConcreteCommand(Receiver recever) {
        this.recever = recever;
    }

    @Override
    public void execute() {
        recever.processA();
        recever.processB();
    }
}


