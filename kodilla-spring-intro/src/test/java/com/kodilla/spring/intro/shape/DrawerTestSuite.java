package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawerTestSuite {

    @Test
<<<<<<< HEAD
    void testDoDrawing() {
        //Given
        Drawer drawer = new Drawer();

        //When
        drawer.doDrawing();

        //Then
        //do nothing
=======
    void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();

        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();

        //When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a triangle", result);
>>>>>>> 4205745 (14.1 DI, IoC)
    }
}