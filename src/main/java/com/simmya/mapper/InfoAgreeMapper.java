package com.simmya.mapper;

import com.simmya.pojo.InfoAgree;

public interface InfoAgreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(InfoAgree record);

    int insertSelective(InfoAgree record);

    InfoAgree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoAgree record);

    int updateByPrimaryKey(InfoAgree record);
}