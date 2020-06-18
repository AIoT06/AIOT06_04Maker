package com.aiotdelivery.z_hw4;

import com.aiotdelivery.DAO.EmpDAO;
import com.aiotdelivery.bean.EmpBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectEmp")
public class SelectEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		EmpDAO dao = new EmpDAO();
		List<EmpBean> emps;
		emps = dao.getEmpBeans();
		request.setAttribute("emps", emps);
	} // end of doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // end of doPost()
} // end of class GetAllMembers
