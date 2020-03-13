package com.huafanfan.service;

import java.io.IOException;
import java.util.List;

import com.huafanfan.pojo.People;

public interface PeopleService {
	/*
	 * 显示全部
	 */
	List<People> show() throws IOException;
}
