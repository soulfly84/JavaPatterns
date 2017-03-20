package structural;

import java.util.ArrayList;
import java.util.List;

/*Компоновщик объединяет объекты в древовидную структуру для представления иерархии от частного к целому.
 позволяет клиентам обращаться к отдельным объектам и к группам объектов одинаково.*/
class CompositeApp {
    public static void main(String[] args){
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();
        Shape circle = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(circle);

        composite2.addComponent(triangle1);
        composite2.addComponent(circle);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();
    }
}

     interface  Shape{
        void draw();
    }

    class Square implements Shape {
        @Override
        public void draw() {
            System.out.print("Я квадрат");
        }
    }
    class Triangle implements Shape {
        @Override
        public void draw() {
            System.out.print("Я треугольник");
        }
    }
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.print("Я круг");
        }
    }


    class Composite implements Shape {
        private List<Shape> components = new ArrayList<>();

        public void addComponent(Shape component){
            components.add(component);
        }
        public void removeComponent(Shape component){
            components.add(component);
        }



        @Override
        public void draw() {
            //Перебором Вызывает этот метод у всех компонентом - нарисовать
            for (Shape component: components) {
                component.draw();

            }
        }
    }




