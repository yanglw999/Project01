package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //1. upload driver
       // Class.forName("com.mysql.jdbc.Driver"); // this step can be omitted
        //2. access to connection
        String url = "jdbc:mysql://localhost:3306/querypracticedatabase";
        String user = "root";
        String pw = "root";
        // return a connection object
        Connection connection = DriverManager.getConnection(url,user, pw);
        if(connection != null){
            System.out.println(" well done. connected !");
        }else{
            System.out.println("failed connection.");
        }
        // 3. get the object sending sql
        Statement statement = connection.createStatement();
        // 4. execute sql statement
        String sql = "Insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)" +
                "values(240620,'JDBC03','CLERK',7902,'2024-06-19',3000,0,40)," +
                "(240621,'JDBC04','CLERK',7902,'2024-06-19',2500,0,40);";
        int result = statement.executeUpdate(sql);
        // 5. process the result
        System.out.println("affected rows: "+ result);
        // 6. close the resources
        statement.close();
        connection.close();
    }
}
