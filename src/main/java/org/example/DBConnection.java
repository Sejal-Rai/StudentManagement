package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection conn;
    static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/school";
            String root="root";
            String password="mysql";
            conn =DriverManager.getConnection(url,root,password);
            conn.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
return conn;
    }
}
