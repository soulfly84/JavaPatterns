package structural;

public class AdapterApp extends Application implements Database {
    public static void main(String[] args){
        //Связывает Application и Database
        Database database = new Adapter();
        database.insert();
        database.remove();
        database.select();
        database.update();

        //Включение питания Копирование с диска
    }

    @Override
    public void insert() {
        insertObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        selectObject();
    }

    @Override
    public void remove() {
deleteObject();
    }
}
 class Application {
    public void selectObject() {
        System.out.print("selectObject");
    }

    public void updateObject() {

        System.out.print("updateObject");
    }

    public void deleteObject() {
        System.out.print("deleteObject");
    }

    public void insertObject() {

        System.out.print("insertObject");
    }
}

class Adapter extends Application implements Database {

    //Связывает Application и Database
    @Override
    public void insert() {
        insertObject();

    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        selectObject();

    }

    @Override
    public void remove() {
        deleteObject();
    }
}

 interface Database {
    public void insert();
    public void update();
    public void select();
    public void remove();
}
