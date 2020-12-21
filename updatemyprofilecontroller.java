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
 * Servlet implementation class updatemyprofilecontroller
 */
@WebServlet("/updatemyprofilecontroller")
public class updatemyprofilecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatemyprofilecontroller() {
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
		
		parent_tutor pt = new parent_tutor();
		pt.setId(Integer.parseInt(request.getParameter("myid")));
		pt.setName(request.getParameter("signpupname"));
		pt.setIc(request.getParameter("icsignup"));
		pt.setEmail(request.getParameter("signupmail"));
		pt.setPhonenum(request.getParameter("signupphone"));
		
		
		dao.updateMyProfile(pt);
		
		response.sendRedirect("homeAfterUpdateMyProfile.jsp");
	}

}
