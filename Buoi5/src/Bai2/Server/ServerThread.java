package Bai2.Server;

import Bai2.Server.*;
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
            while (true) {
                String chuoi = in.nextLine().trim();
                Scanner sc = new Scanner(chuoi);
                sc.useDelimiter("@");
                int num1 = sc.nextInt();
                String phepToan = sc.next();
                int num2 = sc.nextInt();
                if (phepToan.equals("+")) {
                    out.println(num1 + num2);
                } else if (phepToan.equals("-")) {
                    out.println(num1 - num2);
                } else if (phepToan.equals("*")) {
                    out.println(num1 * num2);
                } else if (phepToan.equals("/")) {
                    out.println((float) num1 / num2);
                }
            }
        } catch (Exception ex) {
            System.out.println("");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
