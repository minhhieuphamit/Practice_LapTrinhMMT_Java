/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hieu Pham
 */
public class Balls {

    private JPanel box;
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x = 0, y = 0, dx = 2, dy = 2;

    public Balls(JPanel box) {
        this.box = box;
    }

    public void draw() {
        Graphics g = box.getGraphics();
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose();
    }

    public void move() {
        // Xóa hình bằng cách vẽ đè lên
        Graphics g = box.getGraphics();
        g.setXORMode(Color.GREEN);
        g.fillOval(x, y, XSIZE, YSIZE);
        x += dx;
        y += dy;
        Dimension d = box.getSize();
        //kiểm tra có đúng các cạnh
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= d.getWidth()) {
            x = d.width - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= d.getHeight()) {
            y = d.height - YSIZE;
            dy = -dy;
        }

        g.fillOval(x, y, dx, XSIZE);
        g.dispose();
    }

    public void run() {
        draw();
        for (int i = 0; i < 5000; i++) {
            move();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
