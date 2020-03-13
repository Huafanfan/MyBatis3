package com.huafanfan.service;

import java.io.IOException;

import com.huafanfan.pojo.PageInfo;

public interface PeopleService {
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
