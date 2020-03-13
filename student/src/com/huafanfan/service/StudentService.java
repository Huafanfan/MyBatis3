package com.huafanfan.service;

import com.huafanfan.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String sname,String tname,String pageSize,String pageNumber);
}
