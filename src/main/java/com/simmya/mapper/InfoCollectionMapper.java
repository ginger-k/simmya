package com.simmya.mapper;

import com.simmya.pojo.InfoCollection;

public interface InfoCollectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(InfoCollection record);

    int insertSelective(InfoCollection record);

    InfoCollection selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoCollection record);

    int updateByPrimaryKey(InfoCollection record);
}