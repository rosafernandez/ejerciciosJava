package edu.upc.eetac.dsa.javaexercices.Ex1_Construct;

/**
 * Created by Marti on 19/01/2016.
 */
public class excConstruct {

    public static void Run() {
        Tree[] arboles = new Tree[4];
        arboles[0] = new Tree(4);
        arboles[1] = new Tree("Roble");
        arboles[2] = new Tree();
        arboles[3] = new Tree(5, "Pino");

        for(Tree arbol : arboles) {
            System.out.println(arbol.toString());
        }
    }
}
