package com.simmya.service.impl;



import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simmya.mapper.BackOrderMapper;
import com.simmya.mapper.OrdersMapper;
import com.simmya.pojo.BackOrder;
import com.simmya.pojo.Orders;
import com.simmya.service.BaseService;
import com.simmya.util.DbUtil;
import com.simmya.vo.OrderV;

@Service
public class OrdersService extends BaseService<Orders>{

	@Autowired
	private OrdersMapper orderMapper;
	@Autowired
	private BackOrderMapper backOrderMapper;
	

	/*
	 * [{'id':'134sdrgtwe43','createTime':'20150805 10:10:10',‘address’:'嘉兴桐乡',
	 * 'boxs':[{'id':'2354234srte','name':'烧麦','TITLE':'烧麦好吃',
	 * 			'detail':'手工烧麦',imageAddress':'接口前缀+/image1.pig',
	 * 			'price':'100','orderWay':'一周一次'，‘orderCount（订阅期限）’：‘5’,‘sendCount(已发期数)’:'3'}]
	 */
	public List<OrderV> listOrders(String id) throws SQLException {
		
		List<OrderV> list = orderMapper.getOrderListByUserid(id);
		return list;
	}


	/*
	 * [{'id':'2354234srte',NAME':'烧麦盒子','TITLE':'烧麦好吃',
	 * 'detail':'手工烧麦',imageAddress':'接口前缀+/image1.pig',
	 * 'shareCount':4,'boxPrice':100,'collectCount':'4'}]
	 */
	public List<Map<String, Object>> listOrders(String userid, String orderid) throws SQLException {
		String sql = "SELECT c.ID id,c.NAME NAME,c.TITLE TITLE,c.DETAIL detail,c.IMAGE_ADDRESS imageAddress, "
				+ " c.SHARE_COUNT shareCount,c.BOX_PRICE boxPrice,c.COLLECT_COUNT collectCount "
				+ " FROM orders a "
				+ " LEFT JOIN ORDER_BOX_REF b ON b.ORDER_ID = a.ID "
				+ " LEFT JOIN box c ON c.ID = b.BOX_ID "
				+ " WHERE a.USER_ID = ? AND a.ID = ?";
		return DbUtil.getMapList(sql, userid, orderid);
	}


	/*
	 * 取消整个订单
	 * 修改订单的状态为： 退订
	 * 订单退订表添加记录
	 */
	public Map<String, Object> backOrderAdd(String id, String orderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Orders od = super.selectByPrimaryKey(orderId);
		if (od == null) {
			map.put("code", "error");
			return map;
		}
		try {
			od.setStatus("退订");
			super.updateSelective(od);
			BackOrder backOrder = new BackOrder();
			backOrder.setOrdersId(orderId);
			backOrder.setUserId(id);
			backOrder.setCreateTime(new Date());
			backOrderMapper.insertSelective(backOrder);
			map.put("code", "success");
		} catch (Exception e) {
			map.put("code", "error");
		}
		return map;
	}


	
	
}
