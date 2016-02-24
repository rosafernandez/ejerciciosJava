package edu.upc.eetac.dsa.javaexercices.Ex4_ExeptionsBinary;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Marti on 25/01/2016.
 */
public class excExeptionsBinary {

    public static void Run() throws IOException {
        String path = "./src/main/java/edu/upc/eetac/dsa/javaexercices/Ex4_ExeptionsBinary/fichero_binario.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Escribe un numero entero (Ex. 4)");
        int ent = scanner.nextInt();
        System.out.println("- Escribe un numero decimal (Ex. 4,5)");
        double dou = scanner.nextDouble();
        System.out.println("- Escribe un carácter (Ex. d)");
        String line = scanner.next();
        BinaryClass bc = new BinaryClass(ent, dou, line.toCharArray()[0]);
        bc.writeVars(path);
        System.out.println();
        BinaryClass bcnew = bc.readVars(path);
        System.out.println(bcnew.toString());
    }
}
