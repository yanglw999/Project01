package com.mysql.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilsTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_member;");
            resultSet = preparedStatement.executeQuery();
            List<T_member> list = new ArrayList<>();
            while(resultSet.next()){
                T_member member = new T_member();
                member.setId(resultSet.getInt("m_id"));
                member.setName(resultSet.getString("m_name"));
                member.setGender(resultSet.getString("gender").charAt(0));
                member.setAge( resultSet.getInt("age"));
                member.setRegisterDate(resultSet.getDate("register_date"));
                member.setClassName(resultSet.getString("class_name"));
                member.setEmail(resultSet.getString("email"));
                list.add(member);
            }
            for(T_member m : list){
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }
    }
}
