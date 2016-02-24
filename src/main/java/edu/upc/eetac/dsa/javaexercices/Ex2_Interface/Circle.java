package edu.upc.eetac.dsa.javaexercices.Ex2_Interface;

import sun.security.provider.certpath.CertStoreHelper;

/**
 * Created by Marti on 19/01/2016.
 */
public class Circle extends CShape {

    private double radius;

    public Circle(double rad) {
        super("circle");
        this.radius = rad;
    }

    public double area() {
        return (Math.PI*Math.pow(this.radius, 2));
    }
}
