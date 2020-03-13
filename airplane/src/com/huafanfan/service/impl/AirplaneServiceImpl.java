package com.huafanfan.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.huafanfan.mapper.AirplaneMapper;
import com.huafanfan.pojo.Airplane;
import com.huafanfan.service.AirplaneService;
import com.huafanfan.util.MyBatisUtil;

public class AirplaneServiceImpl implements AirplaneService{

	@Override
	public List<Airplane> show(int takeid, int landid) {
		return MyBatisUtil.getSession().getMapper(AirplaneMapper.class).selByTakeidLandid(takeid, landid);
	}

}
