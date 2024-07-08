package com.mysql.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputQueryTest {

    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabasetest";
        String databaseUser =  "root";
        String databasePW = "root";
        SqlOperator sqlOperator = new SqlOperator(url,databaseUser,databasePW);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input username: ");
        String userName = input.readLine().trim(); // field value of table not user of database
        System.out.println("please input pw: ");
        String pw = input.readLine().trim();
        // bow sql statement is important $$$, no space between variable and '
        String sql = "select * from users where username = '"+ userName + "' and pw = '"+ pw +"' ";

        ResultSet resultSet = sqlOperator.query(sql);
      try {
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String user = resultSet.getString("username");
                    String password = resultSet.getString("pw");
                    String phone = resultSet.getString(4);
                    System.out.println(String.format("%-3d %-15s %-15s %-11s", id, user, password,phone));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlOperator.closeResource();
    }
}
