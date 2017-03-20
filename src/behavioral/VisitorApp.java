package behavioral;

/**
 * Посетитель - перебирает элементы с разнородным интерфейсом.
 Обработку действий отдаем посетителю
 https://www.youtube.com/watch?v=iNt_UAHOvAE&index=19&list=PLwcDaxeEINactCC4mly7RQon5juIpH-Q3
 */
public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();

        Visitor hooligan = new HooliganVisitor();

        body.accept(hooligan);
        engine.accept(hooligan);

    }
    /*Вывод:
    Постучал по кузову
    Завел двигатель*/
}

//Посетитель
interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}

//Элемент - автозапчасть
interface Element{
    void accept(Visitor visitor);
}

//Кузов
class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
//Двигатель
class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по кузову");

    }
}

class MechanicVisitor implements Visitor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Проверил кузов");

    }
}