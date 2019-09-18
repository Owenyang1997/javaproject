package com.jia.web.people;

import com.jia.bean.user;
import com.jia.service.Service;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user user=new user();
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Service service=new Service();
        boolean flg=service.login(user);
        if(flg){
            response.sendRedirect(request.getContextPath()+"/getPassageList");
        }else{
            //登陆失败
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
