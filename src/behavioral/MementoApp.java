package behavioral;

/**
 не нарушая инкапсуляцию, фискирует и сохраняет внутреннее состояние объекта так,
 чтобы позднее восстановить его в это состояние.
 */
public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("Уровень 1", 3000);
        System.out.println(game);

        //Сохранить игру
        File file = new File();
        file.setSave(game.save());

        //Снова играем
        game.set("Уровень 2", 5000);
        System.out.println(game);

        //Откатить к предыдущему сохранению
        System.out.println("Загружаемся");
        game.load(file.getSave());
        System.out.println(game);

        /*вывод
        * Game [level =Уровень 1, ms = 3000]
        Game [level =Уровень 2, ms = 5000]
        Загружаемся
        Game [level =Уровень 1, ms = 3000]
        */

    }
}
//Originator
class Game{
    private String level;
    private int ms;

    public void set(String level, int ms){
        this.level=level;
        this.ms= ms;
    }

    //Сохранять игру
    public Save save(){
        return new Save(level, ms);
    }

    //Загружать игру
    public void load(Save save){
        level = save.getLevel();
        ms = save.getMs();
    }

    @Override
    public String toString() {
        return "Game [level =" + level + ", ms = " + ms + "]";
    }
}
class Save{
    private final String level;
    private final  int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}
class File{
    Save save;

    public void setSave(Save save) {
        this.save = save;
    }

    public Save getSave() {
        return save;
    }
}
