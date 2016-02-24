package edu.upc.eetac.dsa.javaexercices.Ex7_NetworkTCP;

import edu.upc.eetac.dsa.javaexercices.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by Marti on 25/01/2016.
 */
public class serverNetworkTCP extends Thread {

    private int portNum;

    public serverNetworkTCP(String name, int portNum) {
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
