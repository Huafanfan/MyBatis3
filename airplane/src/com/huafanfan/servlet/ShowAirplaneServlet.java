package com.huafanfan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huafanfan.pojo.Airplane;
import com.huafanfan.service.AirplaneService;
import com.huafanfan.service.impl.AirplaneServiceImpl;
import com.huafanfan.service.impl.AirportServiceImpl;
@WebServlet("/showairplane")
public class ShowAirplaneServlet extends HttpServlet{
	private AirplaneService airplaneService = new AirplaneServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int takeid = 0;
		String takeIdString = req.getParameter("takeid");
		if (takeIdString!=null&&!takeIdString.equals("")) {
			takeid = Integer.parseInt(takeIdString);
		}
		int landid = 0;
		String landIdString = req.getParameter("landid");
		if (landIdString!=null&&!landIdString.equals("")) {
			landid = Integer.parseInt(landIdString);
		}
		req.setAttribute("list", airplaneService.show(takeid, landid));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
