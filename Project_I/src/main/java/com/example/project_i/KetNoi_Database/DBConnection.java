package com.example.project_i.KetNoi_Database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class DBConnection {
    public static Connection ConnectionDB() {
        /*Connection conn = null;
        //SQLServerDataSource ds = new SQLServerDataSource();
        try {

            //ds.setEncrypt("true");
            //ds.setTrustServerCertificate(true);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=quanLyHhCn;username=sa;password=123";
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }

        return conn;
    }
}*/

        SQLServerDataSource ds = new SQLServerDataSource();
        Connection connection = null;

        ds.setUser("sa"); //user
        ds.setPassword("123"); //password
        ds.setServerName("DESKTOP-UB4KCUD\\SQLEXPRESS"); //server name
        ds.setPortNumber(1433); //port tcp/ip
        ds.setDatabaseName("quanLyHhCn"); //db name
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);
        try {
            connection = ds.getConnection();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        }
        /*try (Connection connection = ds.getConnection()) {
            System.out.println("Connect successfully");
            System.out.println(connection.getMetaData());
            //String url = "jdbc:sqlserver://localhost:1433;databaseName=quanLyHhCn;username=sa;password=123";
            ds = (SQLServerDataSource) DriverManager.getConnection(url);
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return connection;
    }
}
        /*try {
            // connnect to database 'testdb'
            Connection conn = ds.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            //ResultSet rs = stmt.executeQuery("DELETE FROM DMHANG WHERE TENHANG='chim';");
            ResultSet rs = stmt.executeQuery("SELECT * FROM DMHANG");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3) + "  " + rs.getDouble(4));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

