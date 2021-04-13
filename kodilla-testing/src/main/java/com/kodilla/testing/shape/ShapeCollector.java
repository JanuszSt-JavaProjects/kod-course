package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List <Shape> shapesList = new ArrayList();


    boolean addFigure(Shape shape) {
        return shapesList.add(shape);
    }

    boolean removeFigure(Shape shape) {
        return shapesList.remove(shape);
    }

    Shape getFigure(int n) {
        return shapesList.get(n);
    }

    String showFigures() {
        String result ="";

        for (Shape element: shapesList){
            result+=element.getShapeName();

        }
        return result;

    }

}
