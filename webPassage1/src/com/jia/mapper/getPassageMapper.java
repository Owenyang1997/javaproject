package com.jia.mapper;

import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.bean.peotype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface getPassageMapper {
    public List<passage> getPasageList()throws Exception;
    public List<passage> getpassageListByauthour(@Param(value="title")String title)throws Exception;
    public List<passage> getPasageListBytype(@Param(value ="type") String type)throws Exception;
    public List<people>  getPeople(@Param(value ="typeId")int typeId) throws Exception;
    public passage getPassageByCid(@Param(value="cid")String cid) throws Exception;
    public List<peotype> getPeotype()throws Exception;
}
