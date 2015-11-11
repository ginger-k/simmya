package com.simmya.mapper;

import com.simmya.pojo.BackOrder;

public interface BackOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(BackOrder record);

    int insertSelective(BackOrder record);

    BackOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BackOrder record);

    int updateByPrimaryKey(BackOrder record);
}