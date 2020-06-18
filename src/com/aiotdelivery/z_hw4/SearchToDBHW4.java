package com.aiotdelivery.z_hw4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiotdelivery.DAO.EmpDAO;
import com.aiotdelivery.bean.EmpBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/SearchToDBHW4")
public class SearchToDBHW4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// Search
			String keyword = request.getParameter("keyword");
			EmpDAO dao = new EmpDAO();
			List<EmpBean> empSearch;
			empSearch = dao.searchName(keyword);
			request.setAttribute("emps", empSearch);
			
			// forward to jsp
			request.getRequestDispatcher("/hw4/AllInOneHW4.jsp").forward(request, response);
			

	} // end of doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // end of doPost()
} // end of class GetAllMembers
