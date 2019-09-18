package com.jia.web.people;

import com.google.gson.Gson;
import com.jia.bean.passageType;
import com.jia.bean.peotype;
import com.jia.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getPeopleTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service=new Service();
        List<peotype> passageTypes=service.getPeopleTypeList();
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
