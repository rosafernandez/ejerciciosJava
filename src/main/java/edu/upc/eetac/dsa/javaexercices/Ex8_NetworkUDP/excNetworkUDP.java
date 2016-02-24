package edu.upc.eetac.dsa.javaexercices.Ex8_NetworkUDP;

import edu.upc.eetac.dsa.javaexercices.Main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Marti on 26/01/2016.
 */
public class excNetworkUDP {

    private int portNum;
    private String serverIP;

    public excNetworkUDP(int portNum, String serverIP) {
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

        serverNetworkUDP server = new serverNetworkUDP("server TCP", this.portNum);
        server.start();

        byte[] data = new byte[0];
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName(this.serverIP), this.portNum);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);

        byte[] buffer = new byte[458];
        dp = new DatagramPacket(data, data.length);
        ds.receive(dp);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(dp.getData()));
        String time = dis.readUTF();
        System.out.println("Current time: " + time);
    }
}
