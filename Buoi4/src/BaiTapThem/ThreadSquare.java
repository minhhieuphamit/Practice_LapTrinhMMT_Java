/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapThem;

/**
 *
 * @author Hieu Pham
 */
public class ThreadSquare extends Thread {

    private ShareData shareData;

    public ThreadSquare(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (shareData) {
                if (shareData.isStopped()) {
                    break;
                }
                try {
                    shareData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int randomNumber = shareData.getRandomNumber();
                int square = randomNumber * randomNumber;
                System.out.println("Square number " + square);
                shareData.notify();
            }
        }
    }
}
