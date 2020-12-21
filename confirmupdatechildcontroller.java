package intpattfyp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

import intpattfyp.dao.intpattfypDAO;
import intpattfyp.model.*;
/**
 * Servlet implementation class confirmupdatechildcontroller
 */
@WebServlet("/confirmupdatechildcontroller")
public class confirmupdatechildcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmupdatechildcontroller() {
        super();
        dao = new intpattfypDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		child c = new child();
		
		c.setChildid(Integer.parseInt(request.getParameter("childid")));
		c.setChildname(request.getParameter("childname"));
		c.setChildic(request.getParameter("childic"));
		c.setGender(request.getParameter("childgender"));
		
		System.out.println(Integer.parseInt(request.getParameter("childid")));
		
		dao.updatechild(c);

		response.sendRedirect("homeAfterUpdateChild.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
