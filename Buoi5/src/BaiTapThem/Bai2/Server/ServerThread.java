/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem.Bai2.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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

    private static int check_real_integer_number(double n) {
        //flag = 1 => số nguyên
        //flag = 0 => số thực

        int flag = 1;
        if (Math.ceil(n) != Math.floor(n)) {
            flag = 0;
        }
        return flag;
    }

    public void run() {
        try {
            int num = in.nextInt();
            int check = check_real_integer_number(num);
            if (check == 1) {
                String binary = Integer.toBinaryString(num);
                out.println("Binary number: " + binary);
            } else {
                out.println("khong phai la so nguyen");
            }
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
