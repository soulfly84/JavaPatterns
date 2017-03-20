package structural;

//Солздание отложенной загрузки
public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D:/images/my.jpg");//Создаем экз картинки с путем к файлу
        image.display();//Посмотреть
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    String file;//Путь к файлу

    public RealImage(String file) {
        this.file = file;
        load();//Загрузить файл
    }

    void load() {
        System.out.println("Загрузка " + file);
    }

    @Override
    public void display() {
        System.out.println("Просмотр " + file);
    }
}

//Виртуальный прокси
class ProxyImage implements Image {
    String file;
    RealImage image;


    public ProxyImage(String file) {
        this.file = file;
    }

    //Загрузка будет только тогда, когда вызовут этот метод
    @Override
    public void display() {
        if (image == null) {
            //Если нет картинки - загружаем
            image = new RealImage(file);
        }
        //Показать картинку
        image.display();
    }
}