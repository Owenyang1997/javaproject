package com.jia.web.people;

import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.service.Service;
import com.jia.vo.pageProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getPeopleListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPageStr = request.getParameter("currentPage");
        String type =request.getParameter("typeId");
        if(type==null) currentPageStr="1";
        int typeId=Integer.parseInt(type);
        if(currentPageStr==null) currentPageStr="1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示12条
        int currentCount = 6;
        pageProduct<people> pageProduct;
        //从数据库获取信息返回表单
        Service service=new Service();
        pageProduct=service.getPeopleList(currentPage,currentCount,typeId);
        //将数据存到request域中
        request.setAttribute("passageList",pageProduct);
        request.getRequestDispatcher("/peoplelist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
