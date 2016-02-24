package edu.upc.eetac.dsa.javaexercices.Ex3_ExceptionText;

import java.util.Scanner;

/**
 * Created by Marti on 19/01/2016.
 */
public class excExeptionText {

    public static void Run() {
        System.out.println("Introduzca un fichero, pulsa 1 si quiere usar el fichero por defecto (fichero_numeros.txt):");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        if(Integer.parseInt(path) == 1)
            path = "./src/main/java/edu/upc/eetac/dsa/javaexercices/Ex3_ExceptionText/fichero_numeros.txt";
        try {
            System.out.println(path);
            double average = AverageCalculator.CalcAverage(path);
            System.out.println("La media de los números es: " + average);
        }
        catch (FileParsingException ex) {
            ex.printStackTrace();
        }
        catch (BigNumberException ex) {
            ex.printStackTrace();
        }
    }
}
