package com.simmya.mapper;

import java.util.List;

import com.simmya.pojo.Info;

public interface InfoMapper {
	

	List<Info> getTopInfos(int limit);
	
	int deleteByPrimaryKey(String id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}