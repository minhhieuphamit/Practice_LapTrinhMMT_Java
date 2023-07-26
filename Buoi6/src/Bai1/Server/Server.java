/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Hieu Pham
 */
public class Server {

    static final int PORT = 1234;
    private DatagramSocket socket = null;

    public Server() {
        try {
            socket = new DatagramSocket(PORT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void action() {
        InetAddress host = null;
        int port;
        String chuoi = ""; 
        try {
            System.out.println("Server đang lắng nghe...");
            while (true) {
                DatagramPacket packet = receive(); 
                host = packet.getAddress();
                port = packet.getPort();
                chuoi = new String(packet.getData()).trim();
                chuoi = chuoi.toUpperCase();
                if (!chuoi.equals("")) {
                    send(chuoi, host, port);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }

    }

    private DatagramPacket receive() throws IOException {
        byte buffer[] = new byte[65507];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }

    private void send(String chuoi, InetAddress host, int port) throws IOException {
        byte buffer[] = chuoi.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, host, port);
        socket.send(packet);
    }

    public static void main(String[] args) {
        new Server().action();
    }
}
