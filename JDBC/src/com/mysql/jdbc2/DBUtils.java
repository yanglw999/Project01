package com.mysql.jdbc2;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    static { // static block is only run when uploading class
        try {
        InputStream inputStream = DBUtils.class.getResourceAsStream("db.properties");

            PROPERTIES.load(inputStream);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(PROPERTIES.getProperty("url"),
                    PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
            try {
                    if(resultSet!= null) resultSet.close();
                    if(statement != null) statement.close();
                    if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
