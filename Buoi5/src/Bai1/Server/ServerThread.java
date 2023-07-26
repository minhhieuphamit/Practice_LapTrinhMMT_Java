package Bai1.Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hieu Pham
 */
public class ServerThread implements Runnable {

    private Socket socket;
    private String name;
    private PrintWriter out = null;
    private Scanner in = null;

    public ServerThread(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }

    public void run() {
        try {
            String chuoi = in.nextLine().trim();
            chuoi = chuoi.toUpperCase();
            out.println(chuoi);
            System.out.println("Chuỗi nhận được từ client là: " + chuoi);
        } catch (Exception ex) {
            System.out.println(name + "has departed");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
