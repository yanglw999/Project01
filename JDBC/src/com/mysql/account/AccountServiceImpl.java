package com.mysql.account;

public class AccountServiceImpl implements AccountService {
    // registration
    public void register(Account account){

    }
    @Override
    public void transfer(String fromNo, String pwd, String toNo, double amount){
        AccountDAO accountDAO = new AccountDAOImpl();
        Account accountFrom = null;
        Account accountTo = null;
        // 1 verify if fromNo is
        accountFrom = accountDAO.select(fromNo);

        try {// the purpose of re-connect is to create a savepoint//
            // Reconnect// close the autoCommit of transaction
            DBUtils.startTransaction();
            if (accountFrom == null) {
                throw new RuntimeException("The account# of money from does not exist!");
            } else { // 2 verify if pwd is true
                if (!accountFrom.getPassword().equals(pwd)) { // better to use equals()
                    throw new RuntimeException("the pwd is incorrect!");
                }
                // 3 check if balance >= amount
                if (accountFrom.getBalance() < amount) {
                    throw new RuntimeException("The balance is insufficient,so transfer failed!");
                }
                // 4 check if toNo is true
                accountTo = accountDAO.select(toNo);
                if (accountTo == null) {
                    throw new RuntimeException("the destination account does not exist!");
                }
                if(accountFrom.getCardNo().equals(accountTo.getCardNo())){
                    throw new RuntimeException("account NO should not be same!");
                }
                // 5 reduce amount from balance of fromNo
                accountFrom.setBalance(accountFrom.getBalance() - amount);
                accountDAO.update(accountFrom);
                // 6 increase amount to balance of toNo
                // critical area
                accountTo.setBalance(accountTo.getBalance() + amount);
                accountDAO.update(accountTo);
                System.out.println("transfer is done successfully!");
               // after transfer is done, commit
                DBUtils.commitTransaction();
            }
        }catch (Exception e){
            DBUtils.rollBackTransaction();
            e.printStackTrace();  // if Exception happens, roll back
            }

    }

    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.transfer("6002","4568","6002",1000);
    }
}
