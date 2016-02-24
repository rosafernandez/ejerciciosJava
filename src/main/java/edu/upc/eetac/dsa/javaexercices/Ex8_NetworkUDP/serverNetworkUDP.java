package edu.upc.eetac.dsa.javaexercices.Ex8_NetworkUDP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by Marti on 26/01/2016.
 */
public class serverNetworkUDP extends Thread {

    private int portNum;

    public serverNetworkUDP(String name, int portNum) {
        super(name);
        this.portNum = portNum;
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        InetAddress urlAddress;
        try {
            urlAddress = InetAddress.getLocalHost();
            ServerSocket serverSocket = new ServerSocket(this.portNum, 50, urlAddress);
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(sdf.format(System.currentTimeMillis()));
                writer.flush();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
