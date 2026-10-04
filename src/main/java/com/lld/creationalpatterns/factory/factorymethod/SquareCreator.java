package com.lld.creationalpatterns.factory.factorymethod;


import com.lld.creationalpatterns.factory.Shape;
import com.lld.creationalpatterns.factory.Square;

// Step 4: Concrete Creator classes
//public class SquareCreator extends ShapeFactory {
    public class SquareCreator implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Square();
    }
}
