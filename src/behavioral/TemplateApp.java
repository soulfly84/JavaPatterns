    package behavioral;

    /**
     * Шаблонный метод позволяет наследникам переопределять некоторые шаги алгоритма,
     * не изменяя его структуру в целом.
     * Наследники переопределяют различающуюся часть абстр класса
     *
     */
    public class TemplateApp {
        public static void main(String[] args) {

            Jeneral a = new A();
            a.templateMethod();
            System.out.println();

            Jeneral b = new B();
            b.templateMethod();
        }

        /*Вывод
        * 1 2 3 5
        1 4 3 */
    }


    //Общий абстр класс
    abstract class Jeneral {
        void templateMethod() {
            System.out.print("1 ");
            differ();//Эта часть будет меняться
            System.out.print("3 ");
            differ2();
        }

        abstract void differ();
        abstract void differ2();
    }

    class A extends Jeneral {
        @Override
        void differ() {
            System.out.print("2 ");
        }

        @Override
        void differ2() {
            System.out.print("5 ");
        }
    }

    class B extends Jeneral {
        @Override
        void differ() {
            System.out.print("4 ");
        }
        @Override
        void differ2() {
        }
    }
