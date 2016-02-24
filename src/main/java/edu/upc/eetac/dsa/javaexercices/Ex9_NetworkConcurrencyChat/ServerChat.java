package edu.upc.eetac.dsa.javaexercices.Ex9_NetworkConcurrencyChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marti on 24/02/2016.
 */
public class ServerChat implements Runnable {

    private static List<ServerChat> threadList = Collections.synchronizedList(new ArrayList<ServerChat>());
    private Socket s = null;
    private String username = null;
    private BufferedReader r = null;
    private PrintWriter w = null;

    public ServerChat(Socket s) throws IOException {
        this.s = s;
        r = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
        w = new PrintWriter(this.s.getOutputStream());
    }

    public void run()  {
        try {
            String[] msg = null;
            do {
                msg = r.readLine().split(" ", 2);
                if (msg[0].equals("JOIN")) {
                    username = msg[1];
                    Thread.currentThread().setName(username + " thread");
                    threadList.add(this);
                    broadcast("estoy dentro.");
                } else if (msg[0].equals("MESSAGE")) {
                    broadcast(msg[1]);
                }
            } while (!msg[0].equals("LEAVE"));

            threadList.remove(this);
            broadcast("me piro.");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String msg) {
        for (ServerChat t : threadList)
            t.send(username + "> " + msg);
    }

    private void send(String msg) {
        w.println(msg);
        w.flush();
    }
}
