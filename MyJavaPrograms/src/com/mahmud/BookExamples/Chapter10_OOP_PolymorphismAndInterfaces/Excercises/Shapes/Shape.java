package com.mahmud.BookExamples.Chapter10_OOP_PolymorphismAndInterfaces.Excercises.Shapes;

// Shape Abstract Superclass
public abstract class Shape {

    private String ShapeName;

    Shape ()
    {
        ShapeName = "";
    }

    Shape (String name)
    {
        ShapeName = name;
    }

    public void setName (String name)
    {
        this.ShapeName = name;
    }

    public String getName ()
    {
        return ShapeName;
    }

    @Override // indicates that this method overrides a superclass method
    public String toString() {
        return String.format("Shape Name : %s\n", ShapeName);
    }
}