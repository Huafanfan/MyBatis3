package com.huafanfan.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.huafanfan.mapper.AirportMapper;
import com.huafanfan.pojo.Airport;
import com.huafanfan.service.AirportService;
import com.huafanfan.util.MyBatisUtil;

public class AirportServiceImpl implements AirportService{

	@Override
	public List<Airport> showTakePort() {
		SqlSession session = MyBatisUtil.getSession();
		AirportMapper airportMapper = session.getMapper(AirportMapper.class);
		return airportMapper.selTakePort();
	}

	@Override
	public List<Airport> showLandPort() {
		SqlSession session = MyBatisUtil.getSession();
		AirportMapper airportMapper = session.getMapper(AirportMapper.class);
		return airportMapper.selLandPort();
	}

}
