package structural;

public class BridgeApp {
    public static void main(String[] args){
        Car car = new Sedan(new Mersedes());
        car.showDetails();
        //Вывод: Тип SedanПроизводитель - Mersedes
    }
}
//Отвечает за тип авто
abstract class Car{
    Maker maker;
    Car(Maker maker) {
        this.maker = maker;//ссылка на интерфейс производителя
    }
    abstract void showType();
    void showDetails(){
        showType();
        maker.setMaker();
    }
}

class Sedan extends Car {


    public Sedan(Maker maker) {
        super(maker);//Передает производителя
    }
    @Override
    void showType() {
        System.out.print("Тип Sedan ");
    }
}

class HatchBack extends  Car{
    public HatchBack(Maker maker){
        super(maker);//Передает производителя
    }

    @Override
    void showType() {
        System.out.print("Тип HatchBack ");
    }
}

//Отвечает за МАРКУ авто
interface  Maker{
    void setMaker();
}

class Kia implements Maker{
    @Override
    public void setMaker() {
        System.out.print("Производитель -  Kia");
    }
}

class Skoda implements Maker{
    @Override
    public void setMaker() {
        System.out.print("Производитель - Skoda");
    }
}

class Mersedes implements Maker{
    @Override
    public void setMaker() {
        System.out.print("Производитель - Mersedes");
    }
}

