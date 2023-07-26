package Buoi1;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Hieu Pham
 */
public class MyConnection {

    public static Connection getConnect() {
        String database = "QuanLyTaiKhoan";
        String username = "hieu";
        String password = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=" + database + ";user=" + username + ";password=" + password;
            System.out.println(url);
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Da ket noi voi database " + conn.getCatalog());
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}
