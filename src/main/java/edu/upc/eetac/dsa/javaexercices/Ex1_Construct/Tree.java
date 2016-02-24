package edu.upc.eetac.dsa.javaexercices.Ex1_Construct;

/**
 * Created by Marti on 19/01/2016.
 */
public class Tree {

    private int metros;
    private String nombre;

    public Tree () {
        this.metros = 0;
        this.nombre = "árbol";
    }

    public Tree (int metros) {
        this.metros = metros;
        this.nombre = "árbol";
    }

    public Tree (String nombre) {
        this.metros = 0;
        this.nombre = nombre;
    }

    public Tree (int metros, String nombre) {
        this.metros = metros;
        this.nombre = nombre;
    }

    public String toString() {
        String text = "Un " + this.nombre;
        text += (this.metros != 0) ? " de " + this.metros + " metros" : "";
        return text;
    }
}
