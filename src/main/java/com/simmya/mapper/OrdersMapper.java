package com.simmya.mapper;

import org.springframework.stereotype.Repository;

import com.simmya.pojo.Orders;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrdersMapper extends Mapper<Orders> {
   
}