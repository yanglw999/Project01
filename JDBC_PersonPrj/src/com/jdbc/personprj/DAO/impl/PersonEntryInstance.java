package com.jdbc.personprj.DAO.impl;

import com.jdbc.personprj.DAO.EntryInstance;
import com.jdbc.personprj.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonEntryInstance implements EntryInstance <Person>{

    @Override
    public Person getEntry(ResultSet resultSet) {
        Person person = null;
        try {
            person = new Person();
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setId(resultSet.getInt("id"));
            person.setBirthDate(resultSet.getDate("birthDate"));
            person.setEmail(resultSet.getString("email"));
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
