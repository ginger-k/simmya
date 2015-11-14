package com.simmya.service.impl;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simmya.mapper.AddressMapper;
import com.simmya.mapper.BoxMapper;
import com.simmya.pojo.Address;
import com.simmya.pojo.Box;
import com.simmya.pojo.Orders;
import com.simmya.service.BaseService;

@Service
public class OrdersService extends BaseService<Orders>{

	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private BoxMapper boxMapper;
	
	public Map<String, Object> commitOrder(Orders orders) {
		Map<String, Object> map = new HashMap<String, Object>();
		Address address = addressMapper.selectByPrimaryKey(orders.getAddressId());
		Box box = boxMapper.selectByPrimaryKey(orders.getBoxIds());
		if (address == null || box == null) {
			map.put("code", "error");
			return map;
		}
		super.saveSelective(orders);
		map.put("code", "sucess");
		return map;
	}

	/*
	 * [{'id':'134sdrgtwe43','createTime':'20150805 10:10:10',
	 * 'orderWay':'一周一次'，‘address’:'嘉兴桐乡',
	 * 'orderCount（订阅期限）'：‘5’，'sendCount(已发期数)':'3',
	 * 'boxs':[{'id':'2354234srte','name':'烧麦','TITLE':'烧麦好吃','detail':'手工烧麦',imageAddress':'接口前缀+/image1.pig','price':'100'}]
	 */
	public Map<String, Object> listOrders(String id) {
		
		
		return null;
	}
	
	
	
}
