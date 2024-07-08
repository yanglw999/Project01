package com.jdbc.personprj.DAO.impl;

import com.jdbc.personprj.DAO.PersonDAO;
import com.jdbc.personprj.entity.Person;
import com.jdbc.personprj.utils.DAOUtils;
import com.jdbc.personprj.utils.DBUtils;
import com.jdbc.personprj.utils.DateUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private DAOUtils daoUtils = new DAOUtils();
    private Connection connection = DBUtils.getConnection();
    private ResultSet resultSet;
    @Override
    public int insert(Person person) {
        String sql = "insert into Person(name, age, birthDate, email) values(?,?,?,?);";
        Object[] args = {person.getName(), person.getAge(), DateUtils.utilDateToSql(person.getBirthDate()), person.getEmail()};
        int n = daoUtils.commonUpdate(connection,sql, args);
        return 0;
    }

    @Override
    public int update(Person person) {
        String sql = "update person set name=?, age=?, birthDate=?, email=? where id=?;";
        Object[] args = {person.getName(), person.getAge(), DateUtils.utilDateToSql(person.getBirthDate()),
                person.getEmail(),person.getId()};
        int n = daoUtils.commonUpdate(connection,sql, args);
        return n;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from person where id = ?";
        Object args = id;
        return daoUtils.commonUpdate(connection,sql,args);
    }

    @Override
    public Person select(int id) {
        String sql = "select * from person where id = ?";
        Object args = id;
        List<Person> list = daoUtils.commonSelect(connection,new PersonEntryInstance(),sql,args );
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Person> selectAll() {
        String sql = "select * from person;";
        List<Person> list = daoUtils.commonSelect(connection,new PersonEntryInstance(), sql,null);
        return list;
    }
}
