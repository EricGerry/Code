package com.servlet.session;

import com.servlet.bean.Book;
import com.servlet.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/*
* 查看购物车*/
@WebServlet(name = "ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<body background=\"image/CartBG.jpg\">");
        out.write("<h1>我的购物车</h1><br/>");
        out.write("<hr align='center'width='3000'size='50'color='#CC0000'><br/>");

        HttpSession session = request.getSession();

        Map<String, Integer> books = (Map<String, Integer>) session.getAttribute("ShoppingCart");

        if(books == null){
            out.write("您的购物车为空！");
            response.setHeader("refresh","2;url="+request.getContextPath()+"/ShowBook");
            return;
        }
        for (Map.Entry<String, Integer> book : books.entrySet()){
            Book b = new Book();
            b = Util.findBookById(book.getKey());
            double APrice = b.getPrice()*book.getValue();
            out.write(" 名称： "+b.getName()+" 数量： "+book.getValue()+" 总价： "+APrice+"<br/>");
            out.write("<hr align='center'width='3000'size='10'color='#00FFFF'><br/>");
        }
        String url1 = request.getContextPath()+"/ShowBook";
        out.write("<a href='" + url1 + "'>返回购物</a><br/>");
        String url2 = request.getContextPath()+"/BuySuccess.jsp";
        out.write("<a href='" + url2 + "'>确认付款</a><br/>");
        out.print("</body>");

    }
}
