/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu Pham
 */
public class Main {

    static final int PORT = 1234;

    public static void main(String[] args) {
        Chat app = new Chat();
        app.setVisible(true);
        //doan nhan du lieu
        DatagramSocket socket;
        String strContent = "";
        try {
            byte buffer[] = new byte[1024];
            socket = new DatagramSocket(PORT);
            boolean ktFinish = false;
            DatagramPacket receivePacket;
            String stReceive;
            while (ktFinish != true) {
                receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);
                stReceive = new String(receivePacket.getData(), 0, receivePacket.getLength());
                strContent = app.getContentChat();
                strContent += "\nNhan: " + stReceive;
                app.setContentChat(strContent);
                if (stReceive.equals("end.") || stReceive.equals("end.")) {
                    ktFinish = true;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
