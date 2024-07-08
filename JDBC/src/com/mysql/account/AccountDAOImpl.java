package com.mysql.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AccountDAOImpl() {
        connection = DBUtils.getConnection();
    }

    public int insert(Account account){
        return 0;
    }
    public int update(Account account){
        String sql = "update account set password=?, name=?,balance = ? where cardNo = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.setString(2,account.getName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getCardNo());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;}
    public int delete(String cardNo){return 0;}
    public Account select(String cardNo){
        Account account = null;
        String sql = "select * from account where cardNo=?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cardNo);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                account = new Account();
                account.setCardNo(resultSet.getString("cardNo"));
                account.setName(resultSet.getString("name"));
                account.setPassword(resultSet.getString("password"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,resultSet);
        }
        return null;
    }

    public List<Account> selectAll(){
        List<Account> list = new ArrayList<>();
        String sql = "select * from account;";
        Account account = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                account = new Account();
                account.setCardNo(resultSet.getString("cardNo"));
                account.setName(resultSet.getString("name"));
                account.setPassword(resultSet.getString("password"));
                account.setBalance(resultSet.getDouble("balance"));
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
   public void closeAll(){
        DBUtils.closeAll(connection,preparedStatement,resultSet);
   }


}
