package com.servlet.session;

import com.servlet.util.Comm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if(Comm.list.size()!=0) {
            for (int i = 0; i < Comm.list.size(); i++) {
                if (name.equals(Comm.list.get(i).getName()) && pass.equals(Comm.list.get(i).getPass())) {
                    request.setAttribute("name", name);
                    RequestDispatcher dis = request.getRequestDispatcher("loginsuccess.jsp");
                    dis.forward(request, response);
                    return;
                }
            }
            request.setAttribute("msg","请检查您的用户名和密码!");
            request.setAttribute("error","重新登录");
            request.setAttribute("url","login.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("loginerror.jsp");
            dis.forward(request, response);
        }else {
            request.setAttribute("msg","您还没有注册!");
            request.setAttribute("error","注册");
            request.setAttribute("url","regist.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("loginerror.jsp");
            dis.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
