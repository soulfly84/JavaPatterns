package structural;
/*позволяющий скрыть сложность системы путём сведения всех возможных внешних вызовов к одному объекту,
делегирующему их соответствующим объектам системы.*/
public class FacadeApp {
    public static void main(String[] args){
        Computer computer = new Computer();
        computer.copy();
        //Включение питания Копирование с диска
    }
}
//Это Фасад, позволяющий скрыть сложность системы путём сведения
// всех возможных внешних вызовов к одному объекту, делегирующему
// их соответствующим объектам системы.
class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on(); //включаем комп
        dvd.load();//вставили диск в dvdRom
        hdd.copyFromDVD(dvd);//Передаем на hdd данные с dvd
    }
}

class Power {
    void on() {
        System.out.println( "Включение питания");
    }

    void off() {
        System.out.println( "Выключение питания");
    }
}

class DVDRom {
    public boolean hasData() {
        return data;
    }

    private boolean data = false;

    void load() {
        data = true;
    }

    void unLoad() {

        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.print( "Копирование с диска");
        } else
            System.out.print( "Вставьте диск");
    }
}