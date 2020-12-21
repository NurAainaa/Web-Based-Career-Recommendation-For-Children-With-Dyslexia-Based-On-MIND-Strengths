package intpattfyp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intpattfyp.dao.intpattfypDAO;
import intpattfyp.model.*;
/**
 * Servlet implementation class updatechildcontroller
 */
@WebServlet("/updatechildcontroller")
public class updatechildcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatechildcontroller() {
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
		
		int childid = Integer.parseInt(request.getParameter("childid"));
		String childname = request.getParameter("childname");
		String childic = request.getParameter("childic");
		String childgender = request.getParameter("childgender");
		
		response.sendRedirect("updatequestans.jsp?childname="+childname+"&childic="+childic+"&childgender="+childgender+"&childid="+childid);
	}

}
