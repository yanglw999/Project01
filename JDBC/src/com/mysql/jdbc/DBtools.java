package com.mysql.jdbc;

import java.sql.*;

public class DBTools {
    static {
        try {
            // uploaded to JMV at first time, next time it will check but not upload again
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // getConnection()
    public static Connection getConnection(String url, String usr, String pw){
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    // closeAll()
    public static void closeAll(Connection connection, Statement stmt, ResultSet rt){
        try {
                if(rt != null)  rt.close();
                if(stmt != null)    stmt.close();
                if(connection != null)  connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {

    }

}
