package com.jia.service.serviceImpl;

import com.jia.bean.passage;
import com.jia.bean.people;
import com.jia.bean.peotype;
import com.jia.mapper.getPassageMapper;
import com.jia.service.getPassageService;
import com.jia.vo.passagevo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class getPassageServiceImpl implements getPassageService {
    @Autowired
    private getPassageMapper passageMapper;
    public List<passage> getPassage() throws Exception {
        return passageMapper.getPasageList();
    }

    @Override
    public List<passage> getPassageByType(String type) throws Exception {
        return passageMapper.getPasageListBytype(type);
    }

    @Override
    public List<passage> getPassageByAuthour(String authour) throws Exception {

        return passageMapper.getpassageListByauthour(authour);
    }

    @Override
    public List<people> getPeople(int state) throws Exception {
        return passageMapper.getPeople(state);
    }

    @Override
    public passage getPassageByCid(String cid) throws Exception {
        return passageMapper.getPassageByCid(cid);
    }

    @Override
    public List<peotype> getPeotype() throws Exception {
        return  passageMapper.getPeotype();
    }

}
