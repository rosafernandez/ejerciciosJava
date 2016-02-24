package edu.upc.eetac.dsa.javaexercices.Ex2_Interface;

/**
 * Created by Marti on 19/01/2016.
 */
public class Rectangle extends CShape {

    private int height;
    private int width;

    public Rectangle(int h, int w) {
        super("rectangle");
        this.height = h;
        this.width = w;
    }

    public double area() {
        return (this.height * this.width);
    }
}
