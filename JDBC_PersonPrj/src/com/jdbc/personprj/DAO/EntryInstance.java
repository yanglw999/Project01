package com.jdbc.personprj.DAO;

import java.sql.ResultSet;

public interface EntryInstance<T> {
    T getEntry(ResultSet resultSet);
}
