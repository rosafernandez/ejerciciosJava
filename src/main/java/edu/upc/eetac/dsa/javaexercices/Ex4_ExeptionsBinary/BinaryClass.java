package edu.upc.eetac.dsa.javaexercices.Ex4_ExeptionsBinary;

import java.io.*;

/**
 * Created by Marti on 25/01/2016.
 */
public class BinaryClass {

    private int entero;
    private double decimal;
    private char caracter;

    public BinaryClass(int ent, double dec, char cha) {
        this.entero = ent;
        this.decimal = dec;
        this.caracter = cha;
    }

    public String toString() {
        String text = "Integrer: " + this.entero + "\n";
        text += "Double: " + this.decimal + "\n";
        text += "Char: " + this.caracter + "\n";
        return text;
    }

    public void writeVars(String path) throws IOException {
        DataOutputStream ds = new DataOutputStream(new FileOutputStream(path));
        ds.writeInt(entero);
        ds.writeDouble(decimal);
        ds.writeChar(caracter);
        ds.close();
    }

    public BinaryClass readVars(String path) throws IOException {
        DataInputStream ds = new DataInputStream(new FileInputStream(path));
        int ent = ds.readInt();
        double dec = ds.readDouble();
        char cha = ds.readChar();
        return (new BinaryClass(ent, dec, cha));
    }
}
