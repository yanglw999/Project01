package com.mysql.account;

import java.util.List;

public interface AccountDAO {
    int insert(Account account);
    int update(Account account);
    int delete(String cardNo);
    Account select(String cardNo);
    List<Account> selectAll();
}
