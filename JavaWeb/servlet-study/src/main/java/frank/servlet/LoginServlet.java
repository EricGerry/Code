package frank.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

// 浏览器访问/login这个路径，就可以执行servlet中的service方法
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码及响应类型：在servlet中都要进行设置
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");//设置响应体
        //设置浏览器解析的类型：响应头Content-Type值
        resp.setContentType("text/html; charset=UTF-8");

        // 获取请求数据：通过键获取值，如果获取不到，值就为null
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 响应数据给客户端
        PrintWriter pw = resp.getWriter();

        // 模拟用户登录的校验步骤
        if(!"stu".equals(username) || ! "123".equals(password)){
            resp.setStatus(403);
            pw.println("<p>用户名或密码输入不正确</p>");
        }else{
            // getSession()=getSession(true)，
            // 表示获取当前用户的session信息，如果获取不到，就创建一个
            HttpSession session = req.getSession();
            session.setAttribute("user", username+"="+password);
            pw.println("用户登录成功");
        }
        pw.flush();
    }
}
