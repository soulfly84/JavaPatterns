package behavioral;

/*Реализует последовательный  доступ к коллекции.*/
public class IteratorApp {
    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator it = c.getIterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }

    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}
//Container
interface Container {
    Iterator getIterator();
}

//ConcreteAgregate
class Tasks implements Container {
    String[] tasks = {"Постороить дом", "Вырастить сына", "Посадить дерево"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    //Конкретный итератор, который будет работать с коллекцией задач
    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length)
                return true;
            else return false;
        }

        @Override
        public Object next() {
            //возвращает эл-т по индексу по порядку
            return tasks[index++];
        }
    }
}
