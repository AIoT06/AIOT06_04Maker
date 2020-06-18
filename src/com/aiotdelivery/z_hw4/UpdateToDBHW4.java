package com.aiotdelivery.z_hw4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiotdelivery.DAO.EmpDAO;
import com.aiotdelivery.bean.EmpBean;

import java.io.IOException;

@WebServlet("/UpdateToDBHW4")
public class UpdateToDBHW4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UPDATE
		EmpBean emp = new EmpBean();
		emp.setEmpno(request.getParameter("empno"));
		emp.setEname(request.getParameter("ename"));
		emp.setHiredate(request.getParameter("hiredate"));
		emp.setSalary(request.getParameter("salary"));
		emp.setDeptno(request.getParameter("deptno"));
		emp.setTitle(request.getParameter("title"));

		EmpDAO dao = new EmpDAO();
		dao.updateEmp(emp);

		// forward to jsp
		request.getRequestDispatcher("AllInOneHW4").forward(request, response);
	} // end of doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // end of doPost()
} // end of class GetAllMembers
