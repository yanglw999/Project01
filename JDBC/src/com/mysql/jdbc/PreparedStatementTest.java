package com.mysql.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabasetest";
        String dataBaseUser = "root";
        String dataBasePW = "root";
        SqlOperatorInput sqlOperatorInput = new SqlOperatorInput(url,dataBaseUser,dataBasePW);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input username: ");
        String userName = input.readLine().trim(); // field value of table not user of database
        System.out.println("please input pw: ");
        String pw = input.readLine().trim();

        String sql = "select * from users where username = ? && pw =?;";
        sqlOperatorInput.startPreparedStatement(sql);
        sqlOperatorInput.preparedStatement.setString(1,userName);
        sqlOperatorInput.preparedStatement.setString(2,pw);
        ResultSet resultSet = sqlOperatorInput.query();
        try {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String userN = resultSet.getString("username");
                String passCode = resultSet.getString("pw");
                String phone = resultSet.getString(4);
                System.out.println(String.format("%-3d %-15s %-15s %-11s", id, userN, passCode,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlOperatorInput.closeResource();

    }
}
