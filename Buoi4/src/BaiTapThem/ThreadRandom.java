/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem;

import java.util.Random;

/**
 *
 * @author Hieu Pham
 */
public class ThreadRandom extends Thread {

    private ShareData shareData;

    public ThreadRandom(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;

        while (count < 10) {
            synchronized (shareData) {
                int randomNumber = random.nextInt(100) + 1;
                System.out.println("Random number: " + randomNumber);
                shareData.setRandomNumber(randomNumber);
                try {
                    shareData.notify();
                    shareData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count++;
        }
        synchronized (shareData) {
            shareData.setStopped(true);
            shareData.notify();
        }
    }
}
