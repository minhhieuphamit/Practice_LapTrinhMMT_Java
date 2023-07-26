/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem.Bai2.Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Hieu Pham
 */
public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            try {
                System.out.print("\nEnter an integer: ");
                int num = sc.nextInt();

                Socket socket = new Socket("127.0.0.1", 1234);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());

                out.println(num);
                String result = in.nextLine().trim();
                System.out.println(result);

                socket.close();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            } catch (Exception ex) {
                ex.printStackTrace();
            }finally{
                continueRunning = true;
            }
        }
    }
}
