package com.mysql.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlOperatorTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/querypracticedatabase";
        String user = "root";
        String pw = "root";
        SqlOperator sqlOperator = new SqlOperator(url, user,pw);
       /* // update entry
        String update1 = "update emp set comm = null where empno = 240621;";
        sqlOperator.updateEntry(update1);
        // delete entry
        String delete1 = "delete from emp where ename = 'JDBC03';";
        sqlOperator.deleteEntry(delete1); */
       // select
        String selectQuery = "select * from emp";
        ResultSet resultSet = sqlOperator.query(selectQuery);
        while (resultSet.next()){
            int empNo =  resultSet.getInt(1);
            String eName =  resultSet.getString("ename");
            String job = resultSet.getString("job");
            int mgr = resultSet.getInt(4);
            Date hireDate = resultSet.getDate(5);
            double salary = resultSet.getDouble(6);
            double compensation = resultSet.getDouble(7);
            int deptNo = resultSet.getInt(8);
            // left alignment
            System.out.printf("%-8d%-12s%-11s%-6d%-12s%-8.2f% -8.2f%4d",empNo, eName,job ,mgr,
                    hireDate.toString(),salary,compensation,deptNo);
            System.out.println();
        }
        resultSet.close();
        sqlOperator.closeResource();
    }
}
