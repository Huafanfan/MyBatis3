package com.huafanfan.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.huafanfan.mapper.StudentMapper;
import com.huafanfan.mapper.TeacherMapper;
import com.huafanfan.pojo.PageInfo;
import com.huafanfan.pojo.Student;
import com.huafanfan.service.StudentService;
import com.huafanfan.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize  = 2;
		if (pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if (pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		pi.setSname(sname);
		pi.setTname(tname);
		
		
		List<Student> list = studentMapper.selByPage(pi);
		//查询处每个学生对应的老师信息
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for (Student student : list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));;
		}
		pi.setList(list);
		
		long count = studentMapper.selCountByPageInfo(pi);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		return pi;
	}
}
