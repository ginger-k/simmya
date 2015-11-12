package com.simmya.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simmya.mapper.InfoAgreeMapper;
import com.simmya.pojo.Info;
import com.simmya.pojo.InfoAgree;
import com.simmya.service.BaseService;
import com.simmya.util.DbUtil;

@Service
public class InfoService extends BaseService<Info>{
	
	@Autowired
	private InfoAgreeMapper infoAgreeMapper;
	
	public List<Map<String, Object>> getTop10(String limit) throws SQLException {
		String sql = "SELECT ID id,NAME NAME,TITLE TITLE,DETAIL detail,COLLECT_COUNT collectCount,"
					+ " AGREE_COUNT agreeCount, DISCUSS_COUNT discussCount,IMAGE_ADDRESS imageAddress,"
					+ " SHARE_COUNT shareCount,SOURCE source,CLICK_COUNT clickCount"
					+ " FROM info ORDER BY click_count DESC LIMIT ?";
		List<Map<String,Object>> mapList = DbUtil.getMapList(sql, Integer.parseInt(limit));
		return mapList;
	}

	public Map<String, Object> getDetailById(String infoid) throws SQLException {
		String sql = "SELECT ID id,NAME NAME,TITLE TITLE,DETAIL detail,COLLECT_COUNT collectCount,"
				+ " AGREE_COUNT agreeCount, DISCUSS_COUNT discussCount,IMAGE_ADDRESS imageAddress,"
				+ " SHARE_COUNT shareCount,SOURCE source,CLICK_COUNT clickCount"
				+ " FROM info where ID = ?";
		Map<String, Object> map = DbUtil.getMap(sql, infoid);
		return map;
	}

	@Transactional
	public void doAgree(String userId, String infoId) {
		//info_agree表添加记录
		//info更新agree_count
		InfoAgree infoAgree = new InfoAgree();
		infoAgree.setUserId(userId);
		infoAgree.setInfoId(infoId);
		infoAgreeMapper.insert(infoAgree);
		Info info = super.selectByPrimaryKey(infoId);
		Integer agreeCount = info.getAgreeCount();
		info.setAgreeCount(agreeCount + 1);
		super.updateSelective(info);
	}
	
}
