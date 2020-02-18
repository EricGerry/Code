package com.Http;

import java.io.IOException;
import java.net.Socket;

public class HttpTask implements Runnable{

    private Request request;
   // private Socket socket;
    private Response response;

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
        response.setStatus(200);
        response.setMessage("OK");
        response.setMessage("正确响应客户端请求！");
        response.flush();
    }
}
