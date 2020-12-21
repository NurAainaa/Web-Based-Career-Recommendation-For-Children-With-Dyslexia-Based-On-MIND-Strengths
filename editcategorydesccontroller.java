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
 * Servlet implementation class editcategorydesccontroller
 */
@WebServlet("/editcategorydesccontroller")
public class editcategorydesccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editcategorydesccontroller() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		quest_catagory c = new quest_catagory();
		c.setQuestcataid(Integer.parseInt(request.getParameter("questid")));
		c.setCatadesc(request.getParameter("quesdesc"));
		dao.updatecatadesc(c);
		
		 response.sendRedirect("AdminhomeAfterUpdateCategory.jsp");
	}

}
