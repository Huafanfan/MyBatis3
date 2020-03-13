package com.huafanfan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huafanfan.pojo.PageInfo;
import com.huafanfan.service.PeopleService;

public class PeopleServiceImpl<V> implements PeopleService{
	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("com.huafanfan.mapper.PeopleMapper.selByOage",map));
		long count = session.selectOne("com.huafanfan.mapper.PeopleMapper.selCount");
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
				
		return pi;
	}
}
