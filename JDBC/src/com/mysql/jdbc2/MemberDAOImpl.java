package com.mysql.jdbc2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MemberDAOImpl {
    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;

    public MemberDAOImpl() {
        connection = DBUtils.getConnection();
    }

    public int insert(T_member member){
        String sql = "insert into t_member(m_name, gender, age, register_date, class_name, email) values(?,?,?,?,?,?);";
        int result = -1;
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2, String.valueOf(member.getGender()));
            preparedStatement.setInt(3,member.getAge());
            preparedStatement.setDate(4, DateUtils.utilDateToSql(member.getRegisterDate()));
            preparedStatement.setString(5,member.getClassName());
            preparedStatement.setString(6,member.getEmail());
            result = preparedStatement.executeUpdate();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
       }
    public int update(T_member member){

    // unlike sql update, we choose to update all fields in the target entry
        String sql = "update t_member set m_name=?, gender=?, age=?, register_date=?, class_name=?, email=? where m_id=?; ";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2, String.valueOf(member.getGender()));
            preparedStatement.setInt(3,member.getAge());
            preparedStatement.setDate(4, DateUtils.utilDateToSql(member.getRegisterDate()));
            preparedStatement.setString(5,member.getClassName());
            preparedStatement.setString(6,member.getEmail());
            preparedStatement.setInt(7,member.getId());
            return   preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null, preparedStatement,null);
        }
        return 0;}
    public int delete(T_member member){
        String sql = "delete * from t_member where id = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, member.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;}
    public int delete(int id){  // delete by id
        String sql = "delete from t_member where m_id = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;}
    public T_member select(int id){ // use primary key to query only one entry
        T_member member = null;

        String sql = "select * from t_member where m_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                member = new T_member();
                member.setId(resultSet.getInt("m_id"));
                member.setName(resultSet.getString("m_name"));
                member.setGender(resultSet.getString("gender").charAt(0));
                member.setAge(resultSet.getInt("age"));
                // class sql.Date extends util.Date
                member.setRegisterDate(resultSet.getDate("register_date"));
                member.setClassName(resultSet.getString("class_name"));
                member.setEmail(resultSet.getString("email"));
            }
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,resultSet);
        }
        return null;}
    public T_member select(String  name){ // use primary key to query only one entry
        T_member member = null;

        String sql = "select * from t_member where m_name = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                member = new T_member();
                member.setId(resultSet.getInt("m_id"));
                member.setName(resultSet.getString("m_name"));
                member.setGender(resultSet.getString("gender").charAt(0));
                member.setAge(resultSet.getInt("age"));
                // class sql.Date extends util.Date
                member.setRegisterDate(resultSet.getDate("register_date"));
                member.setClassName(resultSet.getString("class_name"));
                member.setEmail(resultSet.getString("email"));
            }
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,resultSet);
        }
        return null;}
    public List<T_member> selectAll(){
        String sql = "select * from t_member;";
        List<T_member> list = new LinkedList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            T_member member = null;
            while (resultSet.next()){
                member = new T_member();
                member.setId(resultSet.getInt("m_id"));
                member.setName(resultSet.getString("m_name"));
                member.setGender(resultSet.getString("gender").charAt(0));
                member.setAge(resultSet.getInt("age"));
                // class sql.Date extends util.Date
                member.setRegisterDate(resultSet.getDate("register_date"));
                member.setClassName(resultSet.getString("class_name"));
                member.setEmail(resultSet.getString("email"));
                list.add(member);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,resultSet);
        }
        return list;
    }

    // closeAll
    public void closeAll(){
        DBUtils.closeAll(connection,preparedStatement,resultSet);
    }
}
