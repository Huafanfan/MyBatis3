package com.huafanfan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huafanfan.pojo.People;
import com.huafanfan.service.PeopleService;

/**
 * 在数据访问层和控制器中处理异常，service中只抛出异常。
 * @author alex
 *
 */
public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//前面是工厂  实例化工厂对象时使用的是  构建者设计模式 名称标志：后面有Builder
		//构建者设计模式存在的意义：简化对象实例化过程
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.huafanfan.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}
	

}
