package structural;

/* Декоратор - для динамического подключения дополнительного поведения к объекту.
предоставляет гибкую альтернативу практике создания подклассов с целью расширения функциональности.*/
public class DecoratorApp {
    public static void main(String[] args){
        PrintInterface printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("Привет")));
        printer.print();
        //Вывод: (Привет)
    }
}
interface PrintInterface {
    void print();
}

class Printer implements PrintInterface {

    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class LeftBracketDecorator implements PrintInterface{
    PrintInterface component;

    LeftBracketDecorator(PrintInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("(");
        component.print();

    }
}
class RightBracketDecorator implements PrintInterface{
    PrintInterface component;

    RightBracketDecorator(PrintInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print(")");
    }
}