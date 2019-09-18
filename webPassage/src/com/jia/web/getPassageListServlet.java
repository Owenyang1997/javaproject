package com.jia.web;

import com.jia.bean.passage;
import com.jia.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getPassageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //从数据库获取信息返回表单
        Service service=new Service();
        List<passage> passageList=service.getPassageList();
        //将数据存到request域中
        request.setAttribute("passageList",passageList);
        request.getRequestDispatcher("/design.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
