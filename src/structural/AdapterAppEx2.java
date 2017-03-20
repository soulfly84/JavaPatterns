package structural;

public class AdapterAppEx2 {
    public static void main(String[] args){
        //Вывод варианта 1
        //Рисуем линию Рисуем квадрат Рисуем линию Рисуем квадрат
        VectorRasterInterface g1 = new AdapterVectorFromRaster();
        g1.drawLine();
        g1.drawSquare();

        //Вывод варианта 2
        VectorRasterInterface g2 = new AdapterVectorFromRaster2(new RasterGraphics());
        g1.drawLine();
        g1.drawSquare();
    }
}

//******Вариант 1

interface VectorRasterInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    public void drawRasterLine() {
        System.out.print( "Рисуем линию ");
    }
    public void drawRasterSquare() {
        System.out.print( "Рисуем квадрат ");
    }
}


//Приводит класс RasterGraphics к интерф VectorRasterInterface
//
// Реализация через наследование********************//
class AdapterVectorFromRaster extends RasterGraphics implements VectorRasterInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();

    }
}


//******Вариант 2 - через создание экз----------------
class AdapterVectorFromRaster2  implements VectorRasterInterface{

    RasterGraphics graphic = null;

    AdapterVectorFromRaster2(RasterGraphics graphic) {
        this.graphic = graphic;
    }

    @Override
    public void drawLine() {
        graphic.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        graphic.drawRasterSquare();

    }
}