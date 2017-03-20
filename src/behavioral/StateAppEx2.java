package behavioral;

/**
 * Вариант 2.
 * Переключение контекста (Переход между состояниями) происходит внутри объектов (состояний)
 * Похож на strategy
 *
 */
public class StateAppEx2 {
    public static void main(String[] args) {
        Human human = new Human();//создали человека
        human.setState(new Work());//человек работает
        for (int i = 0; i < 6; i++) {
            human.doSomething();//Цикл из 6-ти дней
        }
/*Вывод
Работаем!
Ура! Отдыхаем!
Ура! Отдыхаем!
Ура! Отдыхаем!
Работаем!
*/

    }
}

//Context - человек
class Human{
    private Activity state;//Активность человека
    public void setState(Activity s){this.state = s;}

    //Что-то делает
    public void doSomething(){
        state.doSomething(this);
    }
}

//State - состояние
interface Activity{
    void doSomething(Human context);
}

//Человек работает
class Work implements Activity{
    @Override
    public void doSomething(Human context) {
        System.out.println("Работаем!");
        context.setState(new Weekend());//меняем состояние объекта чеоез контекст
    }
}

//Человек отдыхает
class Weekend implements Activity{
    private int count = 0;
    @Override
    public void doSomething(Human context) {
        if(count < 3){//Отдыхает 3 дня
            System.out.println("Ура! Отдыхаем!");
            count++;
        }
        else {//Хватит отдыхать, работать!
            context.setState(new Work());
        }


    }
}