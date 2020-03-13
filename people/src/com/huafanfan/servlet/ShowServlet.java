package com.huafanfan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huafanfan.pojo.People;
import com.huafanfan.service.PeopleService;
import com.huafanfan.service.impl.PeopleServiceImpl;

//大部分注解都有默认属性，如果注解中只给默认属性赋值，可以省略属性名
//否则注解格式为（属性名=属性值）
//如果一个属性是数组类型，格式：属性名={值，值}，如果该数组只有一个值，可以省略大括号
//如果属性名不是基本数据类型或者String，而是一个类类型，格式：属性名=@类型
//注解中@表示引用注解声明
@WebServlet(value = {"/show"})
public class ShowServlet extends HttpServlet{
	private PeopleService peopleservice = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<People> list = peopleservice.show();
		req.setAttribute("list", list);
		//相对路径
		//只要路径中以/开头的都叫做全路径。从项目根（WebContent）出发找到其他资源的过程
		//只要不以/开头都是相对路径，相对路径是以当前资源出发找到其他资源的过程
		//如果请求转发 / 表示WebContent目录
		//如果是重定向，静态资源引用，例如<img src=""/> <a hrep=""/> <script src=""/> css引用 其中的 / 都表示tomcat的webapp文件夹根目录
		//服务器根目录
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}
