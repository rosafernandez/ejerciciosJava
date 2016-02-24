package edu.upc.eetac.dsa.javaexercices.Ex9_NetworkConcurrencyChat;


import java.util.Scanner;

/**
 * Created by Marti on 20/02/2016.
 */
public class excChat {

    private static final int DEFAULT_PORT = 8000;

    public static void Run () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleciona un port de conexió: (Pulsa 1 per predeterminat)");
        int port = scan.nextInt();
        port = (port == 1) ? DEFAULT_PORT : port;
        new Thread(new StartServer(port)).start();

        ClientChat cc = new ClientChat(port);
        cc.Run();
    }

}
