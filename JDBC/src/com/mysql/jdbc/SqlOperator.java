package com.mysql.jdbc;

import java.sql.*;

public class SqlOperator {
    private Connection connection;
    private Statement statement;
    static {
        try {// uploaded in memory at the first invoke,
            // next time will be checked but not uploaded again
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public SqlOperator(){
    }
    public SqlOperator(String url, String user, String pw){
        try {
            connection = DriverManager.getConnection(url,user,pw);
            if(connection != null){
                System.out.println(" well done. connected !");
            }else{
                System.out.println("failed connection.");
            }
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertEntry(String sql)  {
        int result = -1;
        try {
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("inserted entry: " + result);
        }
    }
    public void deleteEntry(String sql){
        int result = -1;
        try {
           result =  statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("deleted entry: " + result);
        }
    }
    public void updateEntry(String sql){
        int result = -1;
        try {
           result =   statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("updated entry: " + result);
        }
    }
    public void querySet(String sql){
        ResultSet resultSet = null;
        try {
             resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
              int empNo =  resultSet.getInt(1);
              String eName =  resultSet.getString("ename");
              String job = resultSet.getString("job");
              int mgr = resultSet.getInt(4);
              Date hireDate = resultSet.getDate(5);
              double salary = resultSet.getDouble(6);
              double compensation = resultSet.getDouble(7);
              int deptNo = resultSet.getInt(8);
                // left alignment
                System.out.printf("%-8d%-12s%-9s%-6d%12s%-8.2f%-8.2f%4d",empNo, eName,job ,mgr,
                        hireDate.toString(),salary,compensation,deptNo);
                System.out.println();
            }
            // close the resource
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // query
    public ResultSet query(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void closeResource(){
        try {
            if(statement != null)  statement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
