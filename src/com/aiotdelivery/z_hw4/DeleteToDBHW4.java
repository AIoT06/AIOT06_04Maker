package com.aiotdelivery.z_hw4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiotdelivery.DAO.EmpDAO;

import java.io.IOException;

@WebServlet("/DeleteToDBHW4")
public class DeleteToDBHW4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// DELETE
			String empno = request.getParameter("empno");
			EmpDAO dao = new EmpDAO();
			dao.deleteEmp(empno);
			
			// forward to jsp
			request.getRequestDispatcher("AllInOneHW4").forward(request, response);
			

	} // end of doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // end of doPost()
} // end of class GetAllMembers
