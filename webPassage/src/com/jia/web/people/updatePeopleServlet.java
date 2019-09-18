package com.jia.web.people;

import com.jia.bean.people;
import com.jia.service.Service;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class updatePeopleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid=request.getParameter("id");
        int id=Integer.parseInt(cid);
        people people=new people();
        Map<String,String[]> map=request.getParameterMap();
        try {
            BeanUtils.populate(people,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Service service=new Service();
        Object typeId=service.getTypeIdByName(people.getType());
        people.setTypeId(typeId);
        Boolean flg=service.updataPeople(id,people);
        System.out.print(flg);
        if(flg){
            //修改成功
            response.sendRedirect(request.getContextPath()+"/getPeopleList?typeId="+typeId);
        }else{
            //修改失败
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
