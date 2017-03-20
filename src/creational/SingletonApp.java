package creational;

public class SingletonApp {
    public static void main(String[] args){
        for (int i = 0; i < 5 ; i++) {
            Singleton s = Singleton.getInstance();
            System.out.print("Singleton номер " +  s.toString());
        }
    }
}

class Singleton {


    private static Singleton instance;
    private static int counter = 0;

    private Singleton() {
        counter++;
    }


    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
