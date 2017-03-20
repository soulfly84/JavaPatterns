package creational;

public class FactoryApp {
    public static void main(String[] args) {
        Worker workerCola = new Worker(new ColaFactory());
        Worker workerPepsi = new Worker(new PepsiFactory());

        workerCola.run();
        workerPepsi.run();

        //Вывод:
        //Залита Кола.
        //Залита Pepesi
    }
}


abstract class AbstractContainer {

    public abstract void pour(AbstractProductWater water);
}

abstract class AbstractFactory {

    //Абстрактн товары, выпускаемые фабрикой
    public abstract AbstractProductWater createWater();

    public abstract AbstractContainer createContainer();
}

abstract class AbstractProductWater {
}


class ColaContainer extends AbstractContainer {
    private static final String TAG = "Factory";

    @Override
    public void pour(AbstractProductWater water) {
        System.out.println("Залита Кола.");
    }
}


class ColaFactory extends AbstractFactory {

    //ColaFactory выпускает ColaWater и ColaContainer
    @Override
    public AbstractProductWater createWater() {
        return new ColaWater();
    }

    @Override
    public AbstractContainer createContainer() {
        return new ColaContainer();
    }
}

class ColaWater extends AbstractProductWater {
}

class PepsiWater extends AbstractProductWater {
}

class PepesiContainer extends AbstractContainer {
    private static final String TAG = "Factory";

    @Override
    public void pour(AbstractProductWater water) {
        System.out.println("Залита Pepesi");
    }
}

class PepsiFactory extends AbstractFactory {
    @Override
    public AbstractProductWater createWater() {
        return new PepsiWater();
    }

    @Override
    public AbstractContainer createContainer() {
        return new PepesiContainer();
    }
}


class Worker {
    //Рабочий производит эти продукты
    private AbstractProductWater water;
    private AbstractContainer container;

    public Worker(AbstractFactory factory) {//на какой фабрике работает рабочий
        //где производится вода
        water = factory.createWater();
        container = factory.createContainer();
    }

    public void run() {
        container.pour(water);

    }
}
