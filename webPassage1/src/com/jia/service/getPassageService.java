package com.jia.service;

import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.bean.peotype;
import java.util.List;

public interface getPassageService {
    public List<passage> getPassage()throws Exception;
    public List<passage> getPassageByType(String type)throws Exception;
    public List<passage> getPassageByAuthour(String authour)throws Exception;
    public List<people>  getPeople(int state) throws Exception;
    public passage getPassageByCid(String cid) throws Exception;
    public List<peotype> getPeotype()throws Exception;
}
