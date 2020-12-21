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
 * Servlet implementation class updatequestanscontroller
 */
@WebServlet("/updatequestanscontroller")
public class updatequestanscontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatequestanscontroller() {
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
		
		questionset c = new questionset();
		
		String childid = request.getParameter("childid");
		String parentid = request.getParameter("parentid");
		
		c.setParentid(Integer.parseInt(request.getParameter("parentid")));
		c.setChildid(Integer.parseInt(request.getParameter("childid")));
		dao.deleteChildAsnById(c);
		
		List<questionset> getAllQuestions = intpattfypDAO.getAllQuestions();
		for (questionset qts : getAllQuestions) {
			questionset qa = new questionset();   
			qa.setQuestid(qts.getQuestsetid());
			qa.setParentid(Integer.parseInt(request.getParameter("parentid")));
			qa.setChildid(Integer.parseInt(request.getParameter("childid")));
		    String questno = Integer.toString(qts.getQuestnum());
		    qa.setAnswer(request.getParameter(questno));
		    dao.addquestansAfterDel(qa);
		}
		 response.sendRedirect("viewchilddetailscontroller?childid="+childid+"&parentid="+parentid);
	}

}
