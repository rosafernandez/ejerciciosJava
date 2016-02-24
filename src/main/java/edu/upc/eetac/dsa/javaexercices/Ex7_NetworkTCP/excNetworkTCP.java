package edu.upc.eetac.dsa.javaexercices.Ex7_NetworkTCP;

import edu.upc.eetac.dsa.javaexercices.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Marti on 25/01/2016.
 */
public class excNetworkTCP {

    private int portNum;
    private String serverIP;

    public excNetworkTCP(int portNum, String serverIP) {
        if(portNum == 1)
            this.portNum = Main.BASE_PORT;
        else
            this.portNum = portNum;

        if(serverIP.compareTo("1") == 0) {
            this.serverIP = "0.0.0.0";
        }
        else {
            this.serverIP = serverIP;
        }
    }

    public void Run() throws IOException {

        serverNetworkTCP server = new serverNetworkTCP("server TCP", this.portNum);
        server.start();

        Socket socket = new Socket(this.serverIP, this.portNum);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String time = br.readLine();
        System.out.println("Current Time: " + time);
        socket.close();
    }
}
