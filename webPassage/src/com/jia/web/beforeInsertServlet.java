package com.jia.web;

import com.jia.bean.passage;
import com.jia.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class beforeInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据并返回
        String cid=request.getParameter("cid");
         Service service=new Service();
         passage passage=service.getPassage(cid);
        //将数据存到request域中
        request.setAttribute("passage",passage);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
