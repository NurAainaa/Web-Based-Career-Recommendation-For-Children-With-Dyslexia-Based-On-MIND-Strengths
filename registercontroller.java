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
 * Servlet implementation class registercontroller
 */
@WebServlet("/registercontroller")
public class registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registercontroller() {
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
		
		parent_tutor pt = new parent_tutor();
		pt.setName(request.getParameter("signpupname"));
		pt.setIc(request.getParameter("icsignup"));
		pt.setEmail(request.getParameter("signupmail"));
		pt.setPhonenum(request.getParameter("signupphone"));
		pt.setPassword(request.getParameter("passconfirmsignup"));
		
		
		
		dao.addParentTutor(pt);
		
		response.sendRedirect("loginAfterRegister.jsp");
	}

}
