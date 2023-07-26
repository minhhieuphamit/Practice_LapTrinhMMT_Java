/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem.Bai1.Server;

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

    public void run() {
        try {
            String chuoi = in.nextLine().trim();
            String arr[] = chuoi.split("@");
            int a, b, c;
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[1]);
            c = Integer.parseInt(arr[2]);
            if (a == 0) {
                if (b == 0) {
                    out.println("Phương trình vô nghiệm!");
                } else {
                    out.println("Phương trình có một nghiệm: "
                            + "x = " + (-c / b));
                }
                return;
            }
            // tính delta
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                out.println("Phương trình có 2 nghiệm là: "
                        + "x1 = " + x1 + " và x2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                out.println("Phương trình có nghiệm kép: "
                        + "x1 = x2 = " + x1);
            } else {
                out.println("Phương trình vô nghiệm!");
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
