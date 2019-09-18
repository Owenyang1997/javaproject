package com.jia.controller;

import com.jia.bean.user;
import com.jia.service.userSevice;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class userController {
    @Autowired
    private userSevice userSevice;
    @RequestMapping("regist")
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        user user=new user();
        Map<String,String[]> map=request.getParameterMap();
        BeanUtils.populate(user,map);
        user.setState(0);
        int a= userSevice.register(user);
        if(a>0){//注册成功
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @RequestMapping("selectUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        user user;
        String idstr=request.getParameter("id");
        if(idstr!=null){
            user u=new user();
            u.setId(idstr);
            user=userSevice.selectUser(u);
            if(user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("/score.jsp").forward(request,response);
            }else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }
    }
}
