package behavioral;

import java.util.Arrays;

/**
 * Стратегия - позволяет выбирать алгоритм путём определения соответствующего класса.
 * Шаблон Strategy позволяет менять выбранный алгоритм независимо от объектов-клиентов, которые его используют.
 * Управляем поведением объекта
 * Сразу задается стратегия сортировки (не внутри объектов, как в шаблоне State)
 */
public class StrategyApp {
    //Реализовать различные алгоритмы сортировки
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();//Создаем клиент стратегии
        int[]arr0 = {1, 3, 2, 1};
        strategyClient.setSrategy(new  SelectionSort());// прими эту стратегию
        strategyClient.executeSrategy(arr0);//Выполни сортировку этого массива


        int[]arr1 = {11, 4, 2, 7, 8 , 5};
        strategyClient.setSrategy(new InsertingSort());// прими эту стратегию
        strategyClient.executeSrategy(arr1);//Выполни сортировку этого массива


        int[]arr2 = {3, -8, 2, 7, 8 , 5, 16};
        strategyClient.setSrategy(new BubbleSort());// прими эту стратегию
        strategyClient.executeSrategy(arr2);//Выполни сортировку этого массива


        }
}

//Context
class StrategyClient {
    Sorting strategy;

    public void setSrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeSrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    //Сортировать массивы
    void sort(int[] arr);
}

//ConcreteStrategy
class BubbleSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка пузырьком");
        System.out.println("до: \t" + Arrays.toString(arr));
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }

        }
        //Вывод массива после сортировки
        System.out.println("после: \t" + Arrays.toString(arr));

    }
}

//ConcreteStrategy2
class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка выборками");
        System.out.println("до: \t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        //Вывод массива после сортировки
        System.out.println("после: \t" + Arrays.toString(arr));

    }
}

//ConcreteStrategy2
class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка вставками");
        System.out.println("до: \t" + Arrays.toString(arr));
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < arr.length; j++)    // Start with 1 (not 0)
        {
            key = arr[j];
            for (i = j - 1; (i >= 0) && (arr[i] < key); i--)   // Smaller values are moving up
            {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = key;    // Put the key in its proper location
        }

        //Вывод массива после сортировки
        System.out.println("после: \t" + Arrays.toString(arr));

    }
}
