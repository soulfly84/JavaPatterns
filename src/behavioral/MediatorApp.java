package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Посредник, обеспечивающий взаимодействие множества объектов,
 * формируя при этом слабую связанность и избавляя объекты от необходимости явно ссылаться друг на друга.
 */

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        AbstractUser admin = new Admin(chat, "Иван Иваныч");
        AbstractUser my = new SimpleUser(chat, "Лена");
        AbstractUser user1 = new SimpleUser(chat, "Ваня");
        AbstractUser user2 = new SimpleUser(chat, "Вова");

        my.setEnable(false);//выключить себя в списке
        //Добавляем админа и юзеров в чат
        chat.setAdmin(admin);
        chat.addUser(my);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("Привет! " + user1.getName());
       //admin.sendMessage("АДМИН зашел в чат!");

    }
}


abstract class AbstractUser {
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public String getName() {
        return name;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public AbstractUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public void sendMessage(String message) {
        //Админ передает от себя сообщение чату
        chat.sendMessage(message, this);

    }

    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User name = " + name;
    }
}

class Admin extends AbstractUser {
    Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Админ получает сообщение от " + message);
    }
}


class SimpleUser extends AbstractUser {
    SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь получает сообщение: " + message);
    }
}


interface Chat {
    void sendMessage(String message, AbstractUser user);
}

class TextChat implements Chat {
    AbstractUser admin;

    List<AbstractUser> users = new ArrayList<>();

    void setAdmin(AbstractUser admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else throw new RuntimeException("Недостаточно прав");

    }

    //Добавит список юзеров в чат
    void addUser(AbstractUser u) {
        if (admin == null)
            throw new RuntimeException("В чате нет админа");

        if (u instanceof SimpleUser) {
            users.add(u);
        } else throw new RuntimeException("Админ не может входить в другой чат! ");

    }

    public void sendMessage(String message, AbstractUser user) {
        //Если админ
        if (user instanceof Admin) {
            for (AbstractUser u : users) {
                u.getMessage(user.getName() + ": " + message);
            }

        }
        //Если простой пользователь
        if(user instanceof SimpleUser ){
            for (AbstractUser u: users) {
                if(u!=user && u.isEnable()){
                    //передаем сообщение всем активным пользователям, кроме себя
                    u.getMessage(user.getName() + ": " + message);
                }
            }
            //Если админ активен, ему тоже отправлять сообщения
            if(admin.isEnable())
                admin.getMessage(user.getName() + ": " + message);
        }

    }
}