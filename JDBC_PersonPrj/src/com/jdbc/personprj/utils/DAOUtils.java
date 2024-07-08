package com.jdbc.personprj.utils;

import com.jdbc.personprj.DAO.EntryInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * repeatedly use insert(),delete(),update() and select()
 */

public class DAOUtils<T> {
    /**
     *
     * @param sql sql have been processed by preparedStatement
     * @param args args_list
     * @return
     */
    public int commonUpdate(Connection connection, String sql, Object ... args){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,null);
        }
        return 0;
    }

    /**
     * select
     * @param connection declared in PersonDAOImpl
     * @param sql
     * @param args
     * @return
     */
    public List<T> commonSelect(Connection connection,EntryInstance<T> entryInstance, String sql, Object ...args){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();
         T t = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if(args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                t = entryInstance.getEntry(resultSet); // EntryInstance interface
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
