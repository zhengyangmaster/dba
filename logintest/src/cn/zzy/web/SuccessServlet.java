package cn.zzy.web;

import cn.zzy.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*获取request域中的共享的对象*/
        User user=(User)request.getAttribute("user");
        if (user != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功"+user.getUsername()+"，欢迎您");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request, response);
    }
}
