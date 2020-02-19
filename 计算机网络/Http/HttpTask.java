package com.Http;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HttpTask implements Runnable{

    private Request request;
   // private Socket socket;
    private Response response;
    //服务端保存session的数据结构（线程安全的map），还可以保存在其他地方，如redis中间件
    private static ConcurrentMap<String, String> SESSIONS = new ConcurrentHashMap<>();

    public HttpTask(Socket socket) {
    //    this.socket = socket;
        try {
            //通过客户端发送的输入流（请求数据）创建Http请求对象
            request = Request.buildRequest(socket.getInputStream());
            response = Response.buildRequest(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的IO流出错",e);
        }

    }


    @Override
    public void run() {
        try {

        //1.根据解析出的request对象中属性，来进行逻辑处理
        //2.在不同逻辑中将要返回的数据设置到response对象中
        //3.刷新响应信息，返回给客户端信息

            if ("/".equals(request.getUrl())){
                response.build200();
                response.println("<h2>HTTP服务器首页</h2>");
            }
         //根据
        //读取项目中html文件内容给客户端
        //1.绝对路径2.相对路径
        //1.html文件所在webapp需要设置为resources资源文件夹
        //2.通过getClassLoader（）.ResourceAsStream()获取文件的输入流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("."+request.getUrl());
        //如果存在，就设置资源内容到response对象
        if (is != null){

            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String content;
            while ((content = br.readLine()) != null){
                response.println(content);
            }
            response.build200();
        }   else if ("/login".equals(request.getUrl())) {
            //1.只接受post请求方法，否则返回405
            if ("post".equalsIgnoreCase(request.getMethod())) {
                response.build405();
                response.println("不支持请求方法：" + request.getMethod());
            } else {
                //2校验用户名密码，校验通过返回（省略校验）
                response.build200();
                response.println("请求的数据" + "username=" + request.getParameter("username"));
                response.println("请求的数据" + "password=" + request.getParameter("password"));
                //session：将信息保存在服务器，并返回给客户端
                String sessionId = UUID.randomUUID().toString();
                SESSIONS.put(sessionId, request.getParameter("username")
                        +","+request.getParameter("password"));
                //第一种：自己定义header头
               // response.addHeader("SessionID", sessionId);
                //第二种：设置到Cookie中,之后访问每个url都会在请求中包含Cookie=sessionId
                response.addHeader("Set-Cookie", sessionId);
            }
            //敏感的url没有登录的时候，不能访问
        }else if ("/sensitive".equals(request.getUrl())){
           String SessionID = request.getHeader("SessionID");
           String userInfo = SESSIONS.get(SessionID);
            System.out.println("==========获取用户信息"+userInfo);
        }else {//以上所有路径都找不到，说明我们服务器不提供url的服务，返回404
            response.build404();
            response.println("找不到资源");
        }
        } catch (IOException e) {
            e.printStackTrace();
            response.build500();
            response.println("服务器出错");
        }finally {
            //返回给客户端
            response.flush();
        }
    }
}
