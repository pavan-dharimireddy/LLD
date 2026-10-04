package com.lld.creationalpatterns.factory.factorymethod;


import com.lld.creationalpatterns.factory.Shape;

// Step 3: Abstract Creator class
//public abstract class ShapeFactory {
//
//    // Factory method - to be implemented by subclasses
//    public abstract Shape createShape();
//
//}

public interface ShapeFactory {

    // Factory method - to be implemented by subclasses
    Shape createShape();

}