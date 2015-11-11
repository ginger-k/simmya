package com.simmya.mapper;

import com.simmya.pojo.BoxCollection;

public interface BoxCollectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(BoxCollection record);

    int insertSelective(BoxCollection record);

    BoxCollection selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BoxCollection record);

    int updateByPrimaryKey(BoxCollection record);
}