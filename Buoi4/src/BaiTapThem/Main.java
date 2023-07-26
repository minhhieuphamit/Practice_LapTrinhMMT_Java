/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem;

import java.io.IOException;

/**
 *
 * @author Hieu Pham
 */
public class Main extends Thread {

    public static void main(String[] args) throws IOException {
        ShareData sharedData = new ShareData();

        ThreadRandom t1 = new ThreadRandom(sharedData);
        ThreadSquare t2 = new ThreadSquare(sharedData);

        t1.start();
        t2.start();
    }
}
