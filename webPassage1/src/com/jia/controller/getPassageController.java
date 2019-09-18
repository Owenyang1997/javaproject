package com.jia.controller;

import com.jia.bean.pageProduct;
import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.bean.peotype;
import com.jia.service.getAwardservice;
import com.jia.service.getPassageService;
import com.jia.vo.passagevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Controller
public class getPassageController {
    @Autowired
    private getPassageService passageService;
    @Autowired
    private getAwardservice awardservice;
    @RequestMapping(value="/getpassage")
    public void getPassage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<passage>passageMessage=passageService.getPassageByType("公告通知");
        List<passagevo>list = new ArrayList<>();
        for(passage p:passageMessage){
            passagevo po=new passagevo();
            if(p.getData()!=null){
                String st[]=p.getData().split("-");
                String day=st[2];
                String mouth=st[0]+"-"+st[1];
                po.setDay(day);
                po.setMouth(mouth);
            }
            po.setPassage(p);
            list.add(po);
        }
        request.setAttribute("passageMessage",list);
        List<passage>work1=passageService.getPassageByAuthour("安卓组");
        List<passage>work2=passageService.getPassageByAuthour("Web组");
        List<passage>work3=passageService.getPassageByAuthour("游戏组");
        request.setAttribute("work1",work1);
        request.setAttribute("work2",work2);
        request.setAttribute("work3",work3);
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示10条
        int currentCount = 9;
        pageProduct<passage> pageProduct;
        //从数据库获取信息返回表单
        pageProduct=awardservice.getAward(currentPage,currentCount);//拿到封装对象
        //将数据存到request域中
        request.setAttribute("pageAward",pageProduct);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    @RequestMapping("/getpeople")
    public void getPeople(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String state =request.getParameter("state");
        int st=Integer.parseInt(state);
        if(state==null)st=1;
        List<people>peopleList=passageService.getPeople(st);
        request.setAttribute("peopleList",peopleList);
        request.getRequestDispatcher("teacher.jsp").forward(request,response);
    }
    @RequestMapping("/detail")
    public void getDetail(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String cid=request.getParameter("cid");
        passage passage=passageService.getPassageByCid(cid);
        request.setAttribute("passage",passage);
        request.getRequestDispatcher("/detail.jsp").forward(request,response);
    }
    @RequestMapping("/getpeotype")
    public void getPeotype(HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<peotype> peopletype=passageService.getPeotype();
        request.setAttribute("peopletype",peopletype);
        request.getRequestDispatcher("/student.jsp").forward(request,response);
    }

}
