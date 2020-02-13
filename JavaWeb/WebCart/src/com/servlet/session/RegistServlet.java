package com.servlet.session;

import com.servlet.bean.User;
import com.servlet.util.Comm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if(name.equals("")||pass.equals("")||name == null||pass == null){
            response.sendRedirect("registerror.jsp");
        }else {
            User u = new User();
            u.setName(name);
            u.setPass(pass);
            Comm.list.add(u);
            response.sendRedirect("registsuccess.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
