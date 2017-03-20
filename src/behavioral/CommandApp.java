package behavioral;


import javax.jws.soap.SOAPBinding;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        user.startComputer();
        user.stopComputer();
        user.resetComputer();
        /*Вывод
        * Comp.start
        * Comp.stop
        * Comp.reset*/

    }
}

interface Command{
    void execute();
}
//Receiver
class Comp{
    void start(){System.out.println("Comp.start");}
    void stop(){System.out.println("Comp.stop");}
    void reset(){System.out.println("Comp.reset");}
}
//Concrete commands
class StartCommand implements Command {
    Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }
    @Override
    public void execute() {
        computer.start();
    }
}
class StopCommand implements Command {
    Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command {
    Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

//Invoker - прослойка между компьютером и пользователем
//он не знает o Computer, а работает через кнопки-комагды - Command
class User{
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}