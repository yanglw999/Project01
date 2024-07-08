package com.mysql.account;

public interface AccountService {
     void transfer(String fromNo, String pwd, String toNo, double amount);
}
