
package com.aiotdelivery.z_hw4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AllInOneHW4")
public class AllInOneHW4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // SELECT (include to SELECT servlet)
            request.getRequestDispatcher("/SelectEmp")
                    .include(request, response);

            // forward to jsp
            request.getRequestDispatcher("/hw4/AllInOneHW4.jsp")
                    .forward(request, response);
    } // end of doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    } // end of doPost()
} // end of class GetAllMembers
