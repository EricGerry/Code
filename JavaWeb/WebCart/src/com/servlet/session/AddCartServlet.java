package com.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/*
* 查看购物车*/
@WebServlet(name = "AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //取得图书的id
        String id = request.getParameter("id");

        //获取session对象
        HttpSession session = request.getSession();
        //将图书的id作为key，数量作为value存放到map中
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("ShoppingCart");
        //说明session是空，第一次向session中存放数据
        if(map == null){
            map = new HashMap<String, Integer>();
        }
        //如果是null的话，即第一次向session中添加该类书籍
        if(map.get(id) == null){
            map.put(id,0);
        }else {
            //说明已经添加过该类数据，value+1；
            map.put(id,map.get(id)+1);
            out.print("<body background=\"image/CartBG.jpg\">");
            out.write("添加成功<br/>");
            out.write("<hr align='center'width='3000'size='10'color='#00FFFF'><br/>");
            String url1 = request.getContextPath()+"/ShowBook";
            out.write("<a href='" + url1 + "'>返回</a><br/>");
            String url2 = request.getContextPath()+"/ShowCart";
            out.write("<a href='" + url2 + "'>结算</a><br/>");
            out.print("</body>");

        }
        session.setAttribute("ShoppingCart", map);
    }
}
