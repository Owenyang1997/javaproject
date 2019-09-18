package com.jia.mapper;

import com.jia.bean.pageProduct;
import com.jia.bean.passage;
import com.jia.vo.page;

import java.util.List;

public interface getAwardmapper {
    List<passage> getAwardlist(page page)throws Exception;//封装分页的list
    int getAwardCount()throws Exception;//分页总页数
}
