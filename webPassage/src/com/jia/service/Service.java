package com.jia.service;
import com.jia.bean.*;
import com.jia.dao.Dao;
import com.jia.vo.pageProduct;

import java.sql.SQLException;
import java.util.List;
public class Service {
    public Boolean submitPassage(passage passage) {
        Dao dao=new Dao();
        int flag=0;
        try {
            flag=dao.submitPassage(passage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag>=1?true:false;
    }
    public pageProduct<passage> getPassageList(int currentPage, int currentCount,String type) {
        //封装pageProduct
        Dao dao=new Dao();
        pageProduct<passage>passageList= new pageProduct<>();
        passageList.setCurrentPage(currentPage);
        passageList.setCurrentCount(currentCount);
        int totalCount=0;
        try {
            totalCount= dao.getTotalCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        passageList.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        passageList.setTotalPage(totalPage);
        int index = (currentPage-1)*currentCount;
        List<passage>list= null;
        try {
            list = dao.getPassageList(currentCount,index,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        passageList.setList(list);
        return passageList;
    }
    public passage getPassage(String cid) {
        Dao dao=new Dao();
        passage passage=null;
        try {
            passage=dao.getPassage(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passage;
    }
    public Boolean eitPassage(String cid,passage passage) {
        Dao dao=new Dao();
        int flg= 0;
        try {
            flg = dao.eitPassage(cid,passage);
            System.out.print(flg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (flg >=1?true:false);
    }
    public Boolean delPassage(String cid) {
        Dao dao=new Dao();
        int flg= 0;
        try {
            flg = dao.delPassage(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flg>=1?true:false;
    }
    public List<passageType> getpassageTypeList() {
        Dao dao=new Dao();
        List<passageType>passageTypes= null;
        try {
            passageTypes = dao.getpassageTypeList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passageTypes;
    }
    public boolean login(user user)  {
        Dao dao=new Dao();
        int flg= 0;
        try {
            flg = dao.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flg>=1?true:false;
    }
    public List<peotype> getPeopleTypeList() {
        Dao dao=new Dao();
        List<peotype>peoTypes= null;
        try {
            peoTypes = dao.getPeopleTypeList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoTypes;
    }
    public pageProduct<people> getPeopleList(int currentPage, int currentCount,int type) {
        Dao dao=new Dao();
        pageProduct<people>passageList= new pageProduct<>();
        passageList.setCurrentPage(currentPage);
        passageList.setCurrentCount(currentCount);
        int totalCount=0;
        try {
            totalCount= dao.getPtotalCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        passageList.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        passageList.setTotalPage(totalPage);
        int index = (currentPage-1)*currentCount;
        List<people>list= null;
        try {
            list = dao.getPeopleList(currentCount,index,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        passageList.setList(list);
        return passageList;
    }

    public Boolean submitPeople(people people) {
        Dao dao=new Dao();
        int flag=0;
        try {
            flag=dao.submitPassage(people);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag>=1?true:false;
    }
    public int getTypeIdByName(String name){
        Dao dao=new Dao();
        int id = 0;
        try {
           id= dao.getTypeIdByName(name).getTypeId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public people getPeople(int id) {
        Dao dao=new Dao();
        people people=null;
        try {
            people=dao.getPeople(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Boolean updataPeople(int id, people people) {
        Dao dao=new Dao();
        int flg= 0;
        try {
            flg = dao.updataPeple(id,people);
            System.out.print(flg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (flg >=1?true:false);
    }

    public Boolean delPeople(int id) {
        Dao dao=new Dao();
        int flg= 0;
        try {
            flg = dao.delPeople(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flg>=1?true:false;
    }
}
