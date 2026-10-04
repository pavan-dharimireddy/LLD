package com.lld.creationalpatterns.factory.simplefactory;

import com.lld.creationalpatterns.factory.*;

public class ShapeFactory {
    public static Shape createShape(ShapeType shapeType) {
        if (shapeType == null) {
            return null;
        }
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
            default -> throw new IllegalStateException("ShapeType doesn't exist.");
        };
    }
}
