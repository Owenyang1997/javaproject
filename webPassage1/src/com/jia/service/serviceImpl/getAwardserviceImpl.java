package com.jia.service.serviceImpl;
import com.jia.bean.pageProduct;
import com.jia.bean.passage;
import com.jia.mapper.getAwardmapper;
import com.jia.service.getAwardservice;
import com.jia.vo.page;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.SQLException;
import java.util.List;
public class getAwardserviceImpl implements getAwardservice {
    @Autowired
    private getAwardmapper awardmapper;
    @Override
    public pageProduct getAward(int currentpage,int currentcount) throws Exception {
        pageProduct<passage>passageList= new pageProduct<>();
        passageList.setCurrentPage(currentpage);
        passageList.setCurrentCount(currentcount);//一页显示条数
        int totalCount=0;
        try {
            totalCount= awardmapper.getAwardCount();//总条数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        passageList.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil(1.0*totalCount/currentcount);//分多少页
        passageList.setTotalPage(totalPage);
        int index = (currentpage-1)*currentcount;//下标与页数的关系
        List<passage> list= null;
        try {
            page p=new page();
            p.setCurrentCount(currentcount);
            p.setIndex(index);
            list = awardmapper.getAwardlist(p);//拿到该页的信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        passageList.setList(list);
        return passageList;//封装对象返回
    }
}
