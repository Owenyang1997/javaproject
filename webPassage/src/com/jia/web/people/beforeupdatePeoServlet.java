package com.jia.web.people;

import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class beforeupdatePeoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("id");
        Service service=new Service();
        int id=Integer.parseInt(cid);
        people people=service.getPeople(id);
        //将数据存到request域中
        request.setAttribute("passage",people);
        request.getRequestDispatcher("/peoupdata.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
