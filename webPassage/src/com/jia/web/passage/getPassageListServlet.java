package com.jia.web.passage;

import com.jia.bean.passage;
import com.jia.service.Service;
import com.jia.vo.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class getPassageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页显示
        request.setCharacterEncoding("utf-8");
        String currentPageStr = request.getParameter("currentPage");
        String type = request.getParameter("type");
        if(currentPageStr==null) currentPageStr="1";
        if(type==null) type="近期任务";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示12条
        int currentCount = 5;
        pageProduct<passage>pageProduct;
          //从数据库获取信息返回表单
        Service service=new Service();
        pageProduct=service.getPassageList(currentPage,currentCount,type);
        //将数据存到request域中
        request.setAttribute("passageList",pageProduct);
        request.getRequestDispatcher("/design.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
