package com.simmya.service.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.simmya.pojo.Box;
import com.simmya.service.BaseService;
import com.simmya.util.DbUtil;

@Service
public class BoxService extends BaseService<Box>{
	
	
	public List<Map<String, Object>> listBox(int start, int size) throws SQLException {
		String sql = "select ID id,NAME NAME,TITLE TITLE,DETAIL detail,"
				+ "	IMAGE_ADDRESS imageAddress,SHARE_COUNT shareCount,"
				+ "	BOX_PRICE boxPrice,COLLECT_COUNT collectCount "
				+ "	from box limit ?,?;";
		return DbUtil.getMapList(sql, start, size);
	}
	
	
}
