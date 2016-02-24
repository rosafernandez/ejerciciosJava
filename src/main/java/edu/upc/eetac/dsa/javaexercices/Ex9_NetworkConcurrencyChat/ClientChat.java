package edu.upc.eetac.dsa.javaexercices.Ex9_NetworkConcurrencyChat;

import com.sun.corba.se.pept.transport.ReaderThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Marti on 24/02/2016.
 */
public class ClientChat {

    private int port;
    private Socket s = null;
    private BufferedReader r = null;
    private PrintWriter w = null;

    public ClientChat(int port) {
        this.port = port;
    }

    public void Run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Qual es tu nombre de usuario?");
            String username = reader.readLine();
            join(username);

            System.out.println("start chat");
            String msg = null;
            while ((msg = reader.readLine()).length() != 0) {
                System.out.println("---> " + msg.length());
                send(msg);
            }
            leave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void join(String username) throws IOException {
        s = new Socket("0.0.0.0", this.port);
        r = new BufferedReader(new InputStreamReader(s.getInputStream()));
        w = new PrintWriter(s.getOutputStream());

        w.println("JOIN " + username);
        w.flush();
    }

    private void leave() throws IOException {
        w.println("LEAVE");
        w.flush();
        System.out.println("Adeu, torni quan vulgui!");
        s.close();
    }

    private void send(String msg) {
        w.println("MESSAGE " + msg);
        w.flush();
    }
}
