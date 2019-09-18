package com.jia.controller;

import com.jia.bean.pageProduct;
import com.jia.bean.passage;
import com.jia.service.getAwardservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class getAwordController {
    @Autowired
    private getAwardservice awardservice;
    @RequestMapping("getaward")
    public void getAword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr == null) currentPageStr = "1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示10条
        int currentCount = 9;
        pageProduct<passage> pageProduct;
        //从数据库获取信息返回表单
        pageProduct = awardservice.getAward(currentPage, currentCount);//拿到封装对象
        //将数据存到request域中
        request.setAttribute("pageAward",pageProduct);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
