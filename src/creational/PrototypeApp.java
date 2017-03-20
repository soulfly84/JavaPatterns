package creational;


public class PrototypeApp {
    public static void main(String[] args) {
        Car bmw = new Car("BMV", "Информация");
        for (int i = 0; i < 2; i++) {
            try {
                Car b = (Car) bmw.clone();
                b.setName("BMW " + i);
                System.out.println(b.getName());
                System.out.println(b.getInfo());

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        }

        //Вывод: BMW 0 Информация BMW 1 Информация BMW 2 Информация

    }
}


class Car implements Cloneable {
    private String name;
    private String info;

    public Car(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}