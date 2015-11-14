package com.simmya.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simmya.constant.ReturnMap;
import com.simmya.pojo.Orders;
import com.simmya.pojo.User;
import com.simmya.service.impl.OrdersService;
import com.simmya.service.impl.UserService;


@Controller
public class OrderController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrdersService orderService;
	
	
	/*
	 * boxids＝"2143123,1234124,2341242"&
	 * orderWay="一周一期/半年一期"&
	 * orderCount=3&
	 * addressId=124234234&
	 * payBalance=80
	 */
	@RequestMapping(value= "/boxs/order", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commitOrder(@RequestHeader(value = "token",required = true)String token,
			@RequestParam(value = "boxids", required = true)String boxids,
			@RequestParam(value = "orderWay", required = true)String orderWay,
			@RequestParam(value = "orderCount", required = true)String orderCount,
			@RequestParam(value = "addressId", required = true)String addressId,
			@RequestParam(value = "payBalance", required = true)String payBalance) {
		if (StringUtils.isBlank(token)) {
			return ReturnMap.BLANK;
		}
		User loginUser = userService.checkLogin(token);
		if (loginUser == null) {
			return ReturnMap.FAULT;
		}
		Orders orders = new Orders();
		orders.setUserId(loginUser.getId());
		orders.setBoxIds(boxids);
		orders.setOrderWay(orderWay);
		orders.setOrderCount(Integer.parseInt(orderCount));
		orders.setAddressId(addressId);
		orders.setStatus("待付款");
		orders.setTotalPrice(new BigDecimal(payBalance));
		orders.setCreateTime(new Date());
		return orderService.commitOrder(orders);
	}
	
	@RequestMapping(value= "/user/orders", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listOrders(@RequestHeader(value = "token",required = true)String token) {
		if (StringUtils.isBlank(token)) {
			return ReturnMap.BLANK;
		}
		User loginUser = userService.checkLogin(token);
		if (loginUser == null) {
			return ReturnMap.FAULT;
		}
		return orderService.listOrders(loginUser.getId());
	}
	
}
