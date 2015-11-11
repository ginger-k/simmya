package com.simmya.mapper;

import com.simmya.pojo.Box;

public interface BoxMapper {
    int deleteByPrimaryKey(String id);

    int insert(Box record);

    int insertSelective(Box record);

    Box selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Box record);

    int updateByPrimaryKey(Box record);
}