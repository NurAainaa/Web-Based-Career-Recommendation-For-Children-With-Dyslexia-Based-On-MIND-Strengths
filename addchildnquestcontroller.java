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
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
/**
 * Servlet implementation class addchildnquestcontroller
 */
@WebServlet("/addchildnquestcontroller")
public class addchildnquestcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addchildnquestcontroller() {
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
		
		child c = new child();
		
		String childic = request.getParameter("childic");
		String parentid = request.getParameter("parentid");
		
		c.setParentid(Integer.parseInt(request.getParameter("parentid")));
		c.setChildname(request.getParameter("childname"));
		c.setChildic(request.getParameter("childic"));
		c.setGender(request.getParameter("childgender"));
		dao.addchild(c);
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm");  
		   LocalDateTime now = LocalDateTime.now();  
		   String curentdatentime = dtf.format(now);
		   
		   
		
		List<questionset> getAllQuestions = intpattfypDAO.getAllQuestions();
		for (questionset qts : getAllQuestions) {
			questionset qa = new questionset();   
			qa.setQuestid(qts.getQuestsetid());
			qa.setParentid(Integer.parseInt(request.getParameter("parentid")));
			qa.setChildname(request.getParameter("childname"));
			qa.setChildic(request.getParameter("childic"));
			qa.setGender(request.getParameter("childgender"));
		    String questno = Integer.toString(qts.getQuestnum());
		    qa.setAnswer(request.getParameter(questno));
		    qa.setCurdate(curentdatentime);
		    dao.addquestans(qa);
		}
		 response.sendRedirect("homeAfterAddChildnQuest.jsp");
	}

}
