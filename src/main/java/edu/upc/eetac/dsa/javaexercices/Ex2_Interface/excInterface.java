package edu.upc.eetac.dsa.javaexercices.Ex2_Interface;

/**
 * Created by Marti on 19/01/2016.
 */
public class excInterface {

    public static void Run() {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(2.5);
        shapes[1] = new Rectangle(3, 5);
        for (Shape shape : shapes) {
            System.out.println(shape + " with area = " + shape.area());
        }
    }
}
