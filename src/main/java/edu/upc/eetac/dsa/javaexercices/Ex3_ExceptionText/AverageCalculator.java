package edu.upc.eetac.dsa.javaexercices.Ex3_ExceptionText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Marti on 19/01/2016.
 */
public class AverageCalculator {

    public final static double CalcAverage(String path) throws FileParsingException, BigNumberException {
        int cnt = 0;
        double suma = 0d;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = "";
            while((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    System.out.println(number);
                    if(number > 1000)
                        throw new BigNumberException("Número mas grande que 1000 en la linea " + (++cnt));
                    suma += number;
                    cnt++;
                }
                catch (NumberFormatException ex) {
                    throw new FileParsingException(ex.getMessage());
                }
            }
        }
        catch (java.io.IOException ex) {
            throw new FileParsingException(ex.getMessage());
        }

        //finally {
            try {
                reader.close();
            }
            catch (IOException ex) {
                System.err.println("Error! No se pudo cerrar el fichero");
            }
       // }
        return suma / cnt;
    }
}
