package creational;


public class FactoryMethod {
    public static void main(String[] args) {
        AbstractCarCreator abstrCarCreator = new ConcreteCarCreator();
        AbstractCar infifnity = abstrCarCreator.create(ConcreteCarCreator.INFINITY);
        AbstractCar toyota = abstrCarCreator.create(ConcreteCarCreator.TOYOTA);
        AbstractCar mazda = abstrCarCreator.create(ConcreteCarCreator.MAZDA);

        System.out.println(infifnity.getInfo());
        System.out.println(toyota.getInfo());
        System.out.println(mazda.getInfo());


        //Вывод: Infinity Toyota Mazda

    }
}

abstract class AbstractCar {
    public abstract String getInfo();
}

abstract class AbstractCarCreator {
    public abstract AbstractCar create(String name);
}

class ConcreteCarCreator extends AbstractCarCreator {
    public static final String INFINITY = "Infinity";
    public static final String TOYOTA = "Toyota";
    public static final String MAZDA = "Mazda";

    @Override
    public AbstractCar create(String name) {
        if (name.equals(INFINITY)) {
            return new Infinity();
        } else if (name.equals(TOYOTA))
            return new Toyota();
        else if (name.equals(MAZDA))
            return new Mazda();

        return null;
    }
}

class Infinity extends AbstractCar {
    @Override
    public String getInfo() {
        return ConcreteCarCreator.INFINITY;
    }
}

class Mazda extends AbstractCar {
    @Override
    public String getInfo() {
        return ConcreteCarCreator.MAZDA;
    }
}

class Toyota extends AbstractCar {
    @Override
    public String getInfo() {
        return ConcreteCarCreator.TOYOTA;
    }
}
