package frank.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shenlong")
public class CallShenlongServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码及响应类型：在servlet中都要进行设置
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");//设置响应体
        //设置浏览器解析的类型：响应头Content-Type值
        resp.setContentType("text/html; charset=UTF-8");

        // 响应数据给客户端
        PrintWriter pw = resp.getWriter();

        // 获取当前http请求用户session信息，如果获取不到，返回null
        HttpSession session = req.getSession(false);
        if(session == null){
            pw.println("神龙已经走了，找不到了");
        }else{
            String user = (String) session.getAttribute("user");
            // 校验用户是否有访问当前url的权限
            if("stu=123".equals(user)){//模拟校验
                pw.println("呼唤来了神龙，但是因为叶公好龙，所以被吓死了");
            }else {
                pw.println("呼唤来的不是神龙，而是魔龙，全部都被毁掉了");
            }
        }

        pw.flush();
    }
}
