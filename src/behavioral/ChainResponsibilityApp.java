package behavioral;

//Цепочка обработчиков события - для организации в системе уровней ответственности.
public class ChainResponsibilityApp {
    public static void main(String[] args) {
        Logger logger = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        logger.setNext(logger1);


        logger.writeMessage("Все хорошо ", Level.INFO);
        logger.writeMessage("Идет отладка ", Level.DEBUG);
        logger.writeMessage("Ошибка ", Level.ERROR);

        /*Вывод
        * Файл Идет отладка
        * СМС Ошибка
        * Файл Ошибка */
    }
}

class Level {
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}

abstract class Logger {
    int priority;
    Logger next;//Ссылка на следующий логгер

    public Logger(int priority) {
        this.priority = priority;
    }
    public void setNext(Logger next) {this.next = next;}

    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        //Если есть следующий логгер
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}

//Логер 1
class SMSLogger extends Logger {
     SMSLogger(int priority) {
        super(priority);
    }

    public void write(String message){
        System.out.println("СМС " + message);
    }
}

//Логер 2
class FileLogger extends Logger {
    FileLogger(int priority) {
        super(priority);
    }

    public void write(String message){
        System.out.println("Файл " + message);
    }
}
