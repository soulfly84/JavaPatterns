package structural;


import java.util.*;

//Создеет объекты 1 раз, а потом их переиспользует
public class FlyWeightApp {
    private static final String SQUARE = "квадрат";
    private static final String POINT = "точка";
    private static final String CIRCLE = "круг";

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        List<ShapeFigure> shapeFigures = new ArrayList<>();

        shapeFigures.add(shapeFactory.getShapes(SQUARE));
        shapeFigures.add(shapeFactory.getShapes(CIRCLE));
        shapeFigures.add(shapeFactory.getShapes(CIRCLE));
        shapeFigures.add(shapeFactory.getShapes(POINT));
        shapeFigures.add(shapeFactory.getShapes(SQUARE));

        Random rand = new Random();
        for (ShapeFigure shape : shapeFigures) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        }


    }
}
    //FlyWeight
    interface ShapeFigure {
        void draw(int x, int y);
    }

    class PointFigure implements ShapeFigure {
        int r = 3;

        @Override
        public void draw(int x, int y) {
            System.out.println("Рисуем точку: " + x + ", " + y);

        }
    }

    class CircleFigure implements ShapeFigure {
        int r = 5;

        @Override
        public void draw(int x, int y) {
            System.out.println("Рисуем круг с радиусом : " + r + " " + x + ", " + y);

        }
    }

    class SquareFigure implements ShapeFigure {
        int r = 5;

        @Override
        public void draw(int x, int y) {
            System.out.println("Рисуем квадрат: " + x + ", " + y);

        }
    }


class ShapeFactory {
//Фабрика создает фигуры и кладет в эту коллекцию ТОЛЬКО 1 РАЗ
    //Эти фигуры потом будут перемспользоваться
    private final Map<String, ShapeFigure> shapes = new HashMap<>();

    public ShapeFigure getShapes(String shapeName) {

        //Проверяем, если такая фигура существует в коллекции shapes
        ShapeFigure shapeFigure = shapes.get(shapeName);
        //если нет - создаем
        if (shapeFigure == null) {
            switch (shapeName) {
                case "круг":
                    shapeFigure = new CircleFigure();
                    break;

                case "квадрат":
                    shapeFigure = new SquareFigure();
                    break;

                case "точка":
                    shapeFigure = new PointFigure();
                    break;
            }
            //и добавляем в эту коллекцию
            shapes.put(shapeName, shapeFigure);
        }
        return shapeFigure;
    }


}