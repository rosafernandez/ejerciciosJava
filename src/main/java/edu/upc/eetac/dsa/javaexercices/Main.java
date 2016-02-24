package edu.upc.eetac.dsa.javaexercices;

import com.sun.glass.ui.SystemClipboard;
import edu.upc.eetac.dsa.javaexercices.Ex1_Construct.excConstruct;
import edu.upc.eetac.dsa.javaexercices.Ex2_Interface.excInterface;
import edu.upc.eetac.dsa.javaexercices.Ex3_ExceptionText.excExeptionText;
import edu.upc.eetac.dsa.javaexercices.Ex4_ExeptionsBinary.excExeptionsBinary;
import edu.upc.eetac.dsa.javaexercices.Ex5_ConcurrencyThreads.excConcurrencyThreads;
import edu.upc.eetac.dsa.javaexercices.Ex6_ConcurrencySincronysm.excConcurrencySincronysm;
import edu.upc.eetac.dsa.javaexercices.Ex7_NetworkTCP.excNetworkTCP;
import edu.upc.eetac.dsa.javaexercices.Ex8_NetworkUDP.excNetworkUDP;
import edu.upc.eetac.dsa.javaexercices.Ex9_NetworkConcurrencyChat.excChat;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost";
    public static final int BASE_PORT = 12345;
    public static String final_URI = null;
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.eetac.dsa.javaexercices package
        final ResourceConfig rc = new ResourceConfig().packages("edu.upc.eetac.dsa.javaexercices");

        String url = (final_URI == null) ? BASE_URI + ":" + BASE_PORT : final_URI;
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(url), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Seleccione una opción de esta lista:");
        System.out.println("\t 1 - Constructores , sobrecarga y sobreescritura.");
        System.out.println("\t 2 - Interfaces.");
        System.out.println("\t 3 - Excepciones, E/S con ficheros de tipo texto.");
        System.out.println("\t 4 - Excepciones, E/S con ficheros de tipo binario.");
        System.out.println("\t 5 - Concurrencia. Threads.");
        System.out.println("\t 6 - Concurrencia. Sincronismo.");
        System.out.println("\t 7 - Comunicaciones en red. TCP no concurrente.");
        System.out.println("\t 8 - Comunicaciones en red. UDP no concurrente.");
        System.out.println("\t 9 - Comunicaciones en red. Servicios concurrentes.");

        System.out.print("Marque un número y pulse enter: ");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        try {
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    excConstruct.Run();
                    break;
                case 2:
                    excInterface.Run();
                    break;
                case 3:
                    excExeptionText.Run();
                    break;
                case 4:
                    excExeptionsBinary.Run();
                    break;
                case 5:
                    excConcurrencyThreads.Run();
                    break;
                case 6:
                    excConcurrencySincronysm.Run();
                    break;
                case 7:
                    System.out.println("Elija el nombre del servidor (Pulse 1 para predeterminado)");
                    String serverName = scanner.next();
                    System.out.println("Elija el numero de puerto (Pulse 1 para predeterminado)");
                    int portNum = scanner.nextInt();
                    excNetworkTCP nTCP = new excNetworkTCP(portNum, serverName);
                    nTCP.Run();
                    break;
                case 8:
                    System.out.println("Elija el nombre del servidor (Pulse 1 para predeterminado)");
                    String serverName2 = scanner.next();
                    System.out.println("Elija el numero de puerto (Pulse 1 para predeterminado)");
                    int portNum2 = scanner.nextInt();
                    excNetworkUDP nUDP = new excNetworkUDP(portNum2, serverName2);
                    nUDP.Run();
                    break;
                case 9:
                    excChat.Run();
                    break;
                default:
                    System.out.println("Número no permitido.");
                    System.exit(-1);
                    break;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Marque un número porfavor.");
            System.exit(-1);
        }

        /*HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%s:%d\nHit enter to stop it...", BASE_URI, BASE_PORT));

        System.in.read();
        server.shutdownNow();*/
    }

}

