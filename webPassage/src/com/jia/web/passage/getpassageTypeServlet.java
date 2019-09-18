package com.jia.web.passage;

import com.google.gson.Gson;
import com.jia.bean.passageType;
import com.jia.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getpassageTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //从数据库读取类别返回到fenlei.jsp
        Service service=new Service();
        List<passageType>passageTypes=service.getpassageTypeList();
        //将数据变为json数据返回
        Gson gson=new Gson();
        String json=gson.toJson(passageTypes);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
