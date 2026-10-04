package com.lld.creationalpatterns.factory.factorymethod;

import com.lld.creationalpatterns.factory.Rectangle;
import com.lld.creationalpatterns.factory.Shape;

// Step 4: Concrete Creator classes
//public class RectangleCreator extends ShapeFactory {
    public class RectangleCreator implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
