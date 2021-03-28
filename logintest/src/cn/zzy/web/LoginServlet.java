package cn.zzy.web;

import cn.zzy.dao.UserDao;
import cn.zzy.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /*获取请求参数*/
        String username =req.getParameter("username");
        String password =req.getParameter("password");
//封装对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        /*调用Userdao的login方法*/
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        /*判断user*/
        if (user==null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
