package cn.zzy.test;

import cn.zzy.dao.UserDao;
import cn.zzy.domain.User;
import org.junit.Test;

public class Usertest {
     @Test
     public void testlogin(){
          User loginuser=new User();
          loginuser.setUsername("nana");
          loginuser.setPassword("123456");
          UserDao  dao=new UserDao();
          User user= dao.login(loginuser);
          System.out.println(user);

     }
}
