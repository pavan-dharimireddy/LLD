package com.lld.creationalpatterns.factory.factorymethod;

import com.lld.creationalpatterns.factory.Circle;
import com.lld.creationalpatterns.factory.Shape;

// Step 4: Concrete Creator classes
//public class CircleCreator extends ShapeFactory {
public class CircleCreator implements ShapeFactory {

    @Override
    public Shape createShape() {
        return new Circle();
    }
}
