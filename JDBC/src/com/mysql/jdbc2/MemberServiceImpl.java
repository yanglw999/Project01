package com.mysql.jdbc2;

public class MemberServiceImpl {
    // registration: a transaction is composed by multiple DAO operations
    public void register(T_member member){
        MemberDAOImpl memberDAO = new MemberDAOImpl();
        //1. query if the client has been there
        T_member client = memberDAO.select(member.getName());
        if(client == null){
            memberDAO.insert(member);
            System.out.println("inserted the new client! ");
        }else{
            System.out.println("The client has existed.");
        }
    }
    public void modifyInfo(T_member member){
        MemberDAOImpl memberDAO = new MemberDAOImpl();
        T_member client = memberDAO.select(member.getId());
        if(client != null){
            memberDAO.update(member);
        }else{
            System.out.println(" the client does not exist!");
        }
    }

    public static void main(String[] args) {
        MemberServiceImpl service = new MemberServiceImpl();
        T_member member1 =
                new T_member("Grace",'F',25,
                        DateUtils.strToUtilDate("2024-05-31"),"Chemistry","grace@gamil.com");
        service.register(member1);
    }

}
