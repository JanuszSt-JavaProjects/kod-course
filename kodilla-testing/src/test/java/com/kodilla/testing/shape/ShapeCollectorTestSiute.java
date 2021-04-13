package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ShapeCollectorTestSiute {


    @DisplayName("Single objects management tests")
    @Nested
    class TestsFiguresManagment {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(30.00, 10.00);

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.shapesList.size());
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(30.00,10.00);
            Shape square = new Square(20.00);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(square);

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.shapesList.size());
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(30.00,10.00);
            Shape circle = new Circle(10.00);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(circle);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(expected, triangle);

        }
    }

    @DisplayName("Summary Class ShapeCollector Method test")
    @Nested
    class TestSummaryShapeCollectorClassMethod {

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(30.00, 10.00);
            Shape square = new Square(20.00);
            Shape circle = new Circle(10.00);

            //When
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            String expected = "TriangleSquareCircle";

            //Then
            Assertions.assertEquals(expected, shapeCollector.showFigures());
        }
    }

}
