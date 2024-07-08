package com.jdbc.personprj.DAO;

import com.jdbc.personprj.entity.Person;

import java.util.List;

public interface PersonDAO {


    int insert(Person person);
    int update(Person person);
    int delete(int id);
    Person select(int id);
    List<Person> selectAll();
}
