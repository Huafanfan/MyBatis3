package com.huafanfan.mapper;

import java.util.List;

import com.huafanfan.pojo.PageInfo;
import com.huafanfan.pojo.Student;

public interface StudentMapper {
	List<Student> selByPage(PageInfo pi);
	
	long selCountByPageInfo(PageInfo pi);
}
