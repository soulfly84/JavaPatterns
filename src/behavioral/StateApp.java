package behavioral;

/*во время выполнения программы объект
 должен менять своё поведение в зависимости от своего состояния.
 Вариант 1.
 * Переключение контекста происходит внутри контекста*/

public class StateApp {
    public static void main(String[] args) {
        Station fm = new RadioFM();//cjplftv станцию
        Radio radio = new Radio();//Контекст
        radio.setStation(fm);//Задаем для радио станцию RadioFM

        //5 раз переключаем радио
        for (int i = 0; i < 5 ; i++) {
            radio.play();
            radio.nextStation();
        }
        /*Вывод
        * Радио FM...Радио Vesti... Радио 7... Радио FM... Радио Vesti...*/

    }
}
///state
interface Station{
    void play();

}
//Context - при различных состояниях меняет поведение
class Radio {
    Station station;

    void setStation(Station st){station=st;}

    //Переключает радиостанции
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioFM());//Переключиться на RadioFM
        }else if(station instanceof RadioFM){
            setStation(new RadioVesti());
        }else if(station instanceof RadioVesti){
            setStation(new Radio7());//Переключиться на Radio7
        }
    }

    //Проигрывать радио
    void play(){
        station.play();
    }
}

class Radio7 implements Station {

    @Override
    public void play() {
        System.out.println("Радио 7...");

    }
}
class RadioFM implements Station {

    @Override
    public void play() {
        System.out.println("Радио FM...");

    }
}

class RadioVesti implements Station {

    @Override
    public void play() {
        System.out.println("Радио Vesti...");

    }
}

