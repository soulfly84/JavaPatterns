package behavioral;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 Создает механизм у класса, который позволяет получать экземпляру объекта этого класса оповещения
 от других объектов об изменении их состояния, наблюдая за ними.
 Похожие шаблоны: «издатель-подписчик», «посредник», «одиночка».
 */
public class ObserverApp {
    public static void main(String[] args) {

        //Создаем издателя
        MeteoStation station = new MeteoStation();
        //Добавляем ему подписчика, выводящиего изменения издателя
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(28, 740 );

    }
}
//Наблюдаемый
interface Observed{
    void addObserver(Observer o);//добавить наблюдателя
    void removeObserver(Observer o);
    void notifyObserver(); //уведомить наблюдателей об изменении
}


class MeteoStation implements Observed{
    int tempreture;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    //Изменяет параметры и вызывает  notify
    void setMeasurements(int t, int p){
        tempreture = t;
        pressure = p;
        notifyObserver();
    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o: observers){
            o.handleIvent(tempreture, pressure);
        }
    }
}

//Интерфейс Наблюдателя
interface Observer{
    void handleIvent(int temp, int pressure);
}

//Конкретные наблюдатели
class ConsoleObserver implements Observer{
    @Override
    public void handleIvent(int temp, int pressure) {
        System.out.println("погода изменилась. Температура = " + temp + ", Давление: " + pressure);
    }
}

class FileObserver implements Observer{
    @Override
    public void handleIvent(int temp, int pressure) {
        //Запишет изменения температуры в файл
        File f;
        try {
            f = new File("C:\\Users\\MSIGE62\\Documents\\TempPressure.txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = " + temp + ", Давление: " + pressure);
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
    }
}