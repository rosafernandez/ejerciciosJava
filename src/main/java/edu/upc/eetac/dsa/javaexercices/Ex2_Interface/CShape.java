package edu.upc.eetac.dsa.javaexercices.Ex2_Interface;

/**
 * Created by Marti on 19/01/2016.
 */
public abstract class CShape implements Shape {
    private String type;

    public CShape(String type) {
        this.type = type;
    }

    public String toString() {
        String text = "I'm a " + this.type;
        return text;
    }

}
