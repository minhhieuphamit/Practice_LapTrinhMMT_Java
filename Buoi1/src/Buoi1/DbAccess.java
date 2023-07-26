/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hieu Pham
 */
class DbAccess {

    private Connection conn;
    private Statement stmt;

    public DbAccess() {
        try {
            MyConnection mycon = new MyConnection();
            conn = mycon.getConnect();
            stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (Exception ex) {
            return -1;
        }
    }

    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (Exception ex) {
            return null;
        }
    }
}
