package com.mysql.jdbc2;

import java.text.ParseException;
import java.util.List;

public class MemberDAOImplTest {
    public static void main(String[] args) throws ParseException {
        MemberDAOImpl memberDAO = new MemberDAOImpl();
        // 1 insert member1 // no need of id
        T_member member1 =
                new T_member("Grace",'F',25,
                        DateUtils.strToUtilDate("2024-05-31"),"Chemistry","grace@gamil.com");

       int result =  memberDAO.insert(member1);
       System.out.println(result);
        // 2 update object needs id
        T_member member2 =
                new T_member(4,"Larry".toLowerCase(),'m',26,
                        DateUtils.strToUtilDate("2024-06-21"),"Physics","larry@gamil.com");
       // memberDAO.update(member2);
        // 3 select one entry
      //  T_member member3 = memberDAO.select(4);
       // System.out.println(member3);
        // 4 delete
      //  System.out.println("affected entry: " + memberDAO.delete(4));
       List<T_member> list =  memberDAO.selectAll();
       for(T_member m : list){
           System.out.println(m);
       }
       // closeAll
        memberDAO.closeAll();
    }
}
