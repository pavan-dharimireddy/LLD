package com.lld.creationalpatterns.factory.simplefactory;

import com.lld.creationalpatterns.factory.Shape;
import com.lld.creationalpatterns.factory.ShapeType;

// Step 3: Simple Factory Demo (Bloated Design)
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        System.out.println("======= Simple Factory Design Pattern ======");

        // set the type you want
        ShapeType shapeType = ShapeType.SQUARE;
        // get the shape
        Shape shape = ShapeFactory.createShape(shapeType);
        shape.draw();
        shape.computeArea();
    }

}
