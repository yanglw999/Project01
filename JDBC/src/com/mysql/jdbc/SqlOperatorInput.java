package com.mysql.jdbc;

import java.sql.*;

public class SqlOperatorInput {
    private Connection connection;
     PreparedStatement preparedStatement;
     static {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
    public SqlOperatorInput(){}
    public SqlOperatorInput(String url, String user, String pw){
        try {

            connection = DriverManager.getConnection(url,user,pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void startPreparedStatement(String sql){
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet query(){
        ResultSet resultSet = null;
        try {
           resultSet =  preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void closeResource(){
        try {
            if(preparedStatement != null)  preparedStatement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
