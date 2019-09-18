package com.jia.dao;

import com.jia.bean.*;
import com.jia.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class Dao {
    public int submitPassage(passage passage) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into passage(cid,type,title,authour,picture,context,data,state) values(?,?,?,?,?,?,?,?)";
        int flg=queryRunner.update(sql,passage.getCid(),passage.getType(),passage.getTitle(),passage.getAuthour()
        ,passage.getPicture(),passage.getContext(),passage.getData(),passage.getState());
        return flg;
    }

    public List<passage> getPassageList(int currentCount,int index,String type) throws Exception{
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from passage where type=? limit ?,?";
        List<passage>passageList=queryRunner.query(sql,new BeanListHandler<passage>(passage.class),type,index,currentCount);
        return passageList;
    }
    public passage getPassage(String cid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from passage where cid=?";
        passage passage=queryRunner.query(sql,new BeanHandler<passage>(passage.class),cid);
        return passage;
    }
    public int eitPassage(String cid,passage passage) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update passage set type =?,title=?,authour=?,context=?,data=?,state=? where cid=?";
        int a=queryRunner.update(sql,passage.getType(),passage.getTitle(),passage.getAuthour()
                ,passage.getContext(),passage.getData(),passage.getState(),cid);
        return a;
    }
    public int delPassage(String cid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="delete from passage where cid=? ";
        int a=queryRunner.update(sql,cid);
        return a;
    }
    public List<passageType> getpassageTypeList() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from passagetype";
        List<passageType>passageTypes=queryRunner.query(sql,new BeanListHandler<passageType>(passageType.class));
        return passageTypes;

    }
    public int getTotalCount(String type) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        Long totalCount;
        String sql="select count(*) from passage where type=?";
        totalCount=(Long)queryRunner.query(sql,new ScalarHandler(),type);
        return totalCount.intValue();
    }
    public int getPtotalCount(int type) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        Long totalCount;
        String sql="select count(*) from people where typeId= ?";
        totalCount=(Long)queryRunner.query(sql,new ScalarHandler(),type);
        return totalCount.intValue();
    }
    public int login(user user) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from user where username=? and password=?";
        Long a= (Long)queryRunner.query(sql,new ScalarHandler(),user.getUsername(),user.getPassword());
        return a.intValue();
    }

    public List<peotype> getPeopleTypeList() throws SQLException{
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from peotype";
        List<peotype>passageTypes=queryRunner.query(sql,new BeanListHandler<peotype>(peotype.class));
        return passageTypes;
    }

    public List<people> getPeopleList(int currentCount, int index,int type) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from people where typeId=? limit ?,?";
        List<people>passageList=queryRunner.query(sql,new BeanListHandler<people>(people.class),type,index,currentCount);
        return passageList;
    }

    public int submitPassage(people people) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into people(name,img,express,typeId,type) values(?,?,?,?,?)";
        int flg=queryRunner.update(sql,people.getName(),people.getImg(),people.getExpress(),people.getTypeId()
        ,people.getType());
        return flg;
    }
    public peotype getTypeIdByName(String name)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from peotype where type=?";
        peotype a=queryRunner.query(sql,new BeanHandler<peotype>(peotype.class),name);
        return a;
    }

    public people getPeople(int id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from people where id=?";
        people people=queryRunner.query(sql,new BeanHandler<people>(people.class),id);
        return people;
    }

    public int updataPeple(int id, people people) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update people set name =?,express=?,typeId=?,type=? where id=?";
        int a=queryRunner.update(sql,people.getName(),people.getExpress(),people.getTypeId(),
                people.getType(),id);
        return a;
    }

    public int delPeople(int id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="delete from people where id=? ";
        int a=queryRunner.update(sql,id);
        return a;
    }
}
