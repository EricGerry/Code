package com.servlet.session;

import com.servlet.bean.Book;
import com.servlet.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
/*
 * 展示书籍
 * */

@WebServlet(name = "ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<body background=\"image/CartBG.jpg\">");
        out.write("<h1>书籍商城</h1><br/>");
        out.write("<hr align='center'width='3000'size='50'color='#CC0000'><br/>");
        Map<String, Book> books = Util.findAllBooks();


        //生成html
        for (Map.Entry<String, Book> book : books.entrySet()){
            String url1 = request.getContextPath()+"/AddCart?id="+book.getKey();
            out.write("<a href='" + url1 + "'>"+" 书号： "+book.getValue().getId()+" 书名： "+book.getValue().getName()+" 单价： "+book.getValue().getPrice()+" 作者： "+book.getValue().getAuthor()+"<br/>");
            out.write("<hr align='center'width='3000'size='10'color='#00FFFF'><br/>");
        }
        String url2 = request.getContextPath()+"/ShowCart";
        out.write("<a href='" + url2 + "'>查看购物车</a><br/>");
        String url3 = request.getContextPath()+"/ClearCart";
        out.write("<a href='" + url3 + "'>清空购物车</a><br/>");
        out.print("</body>");

    }
}
