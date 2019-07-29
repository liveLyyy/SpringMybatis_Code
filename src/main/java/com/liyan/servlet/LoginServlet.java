package com.liyan.servlet;

import com.liyan.pojo.Users;
import com.liyan.service.Impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersServiceImpl usersService;

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        usersService = applicationContext.getBean(UsersServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");

        String codeSession = req.getSession().getAttribute("code").toString();
        if (codeSession.equals(code)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Users users=new Users();
            users.setUsername(username);
            users.setPassword(password);
            Users users1=usersService.Login(users);
            if (users1!=null){
                resp.sendRedirect("main.jsp");
            }else {
                req.setAttribute("error","用户名或密码不正确");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        }else {
            req.setAttribute("error","验证码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }



    }
}
