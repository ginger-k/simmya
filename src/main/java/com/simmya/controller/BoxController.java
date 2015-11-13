package com.simmya.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simmya.service.impl.BoxService;


@Controller
public class BoxController {

	@Autowired
	private BoxService boxService;
	
	/*
	 * start=1&limit=10
	 * {'id':'2354234srte',NAME':'烧麦盒子','TITLE':'烧麦好吃','detail':'手工烧麦',imageAddress':'接口前缀+/image1.pig','shareCount':4,'boxPrice':100,'collectCount':'4'}
	 */
	@RequestMapping(value= "/boxs/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> listBox(@RequestParam(value = "start", required = true)String start,
											 @RequestParam(value = "limit", required = true)String limit) throws SQLException {
		int begin = Integer.parseInt(start);
		int end = Integer.parseInt(limit);
		if (begin < 1 || begin > end)
			return Collections.emptyList();
		int size = end - begin + 1;
		int st = begin - 1;
		return boxService.listBox(st, size);
	}
	
	
}
