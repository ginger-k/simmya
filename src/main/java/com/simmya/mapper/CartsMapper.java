package com.simmya.mapper;

import com.simmya.pojo.Carts;

public interface CartsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Carts record);

    int insertSelective(Carts record);

    Carts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Carts record);

    int updateByPrimaryKey(Carts record);
}