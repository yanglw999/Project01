package com.jdbc.personprj.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*  connect to Database
     *  transaction control
     *  resource release
     */
public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static { // static block is only run when uploading class
        try {
            InputStream inputStream = com.jdbc.personprj.utils.DBUtils.class.getResourceAsStream("db.properties");

            PROPERTIES.load(inputStream);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 1.
    public static Connection getConnection(){
        Connection connection = threadLocal.get(); // first get() is empty
        try {
            if(connection == null) {
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"),
                        PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                threadLocal.set(connection); // add the connect into threadLocal
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void startTransaction(){
        Connection connection = DBUtils.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void commitTransaction(){
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,null,null);
        }
    }
    public static void rollBackTransaction(){
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,null,null);
        }
    }
    // .
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!= null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) {
                connection.close();
                threadLocal.remove();// after shutting connection, clean threadLocal
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
