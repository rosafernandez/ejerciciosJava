package edu.upc.eetac.dsa.javaexercices.Ex9_NetworkConcurrencyChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Marti on 24/02/2016.
 */
public class StartServer implements Runnable {

    int port;

    public StartServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(this.port);
            System.out.println("-----------");
            System.out.println("Server listen to port " + this.port);
            System.out.println("-----------");
            while (true) {
                Socket s = ss.accept();
                new Thread(new ServerChat(s)).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
