package intpattfyp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import intpattfyp.dao.intpattfypDAO;
import intpattfyp.model.*;
import intpattfyp.connection.ConnectionManager;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
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
		
		String loginrole = request.getParameter("loginrole");
		String loginmail = request.getParameter("loginmail");
		String loginpass = request.getParameter("loginpass");
	
		
		ConnectionManager cm = new ConnectionManager();
		parent_tutor pt = null;
		adminacc ac = null;
		
		if ( (loginrole.equalsIgnoreCase("non-admin")) == true ) {
			try {
				pt = cm.parentTutorLogin(loginmail, loginpass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ( (loginrole.equalsIgnoreCase("admin")) == true ) {
			try { 
				ac = cm.adminlogin(loginmail, loginpass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (pt == null && ac == null) {
			request.setAttribute("fail", "Invalid Email and/or Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (pt != null && ac == null){

			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", pt);

			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else if (pt == null && ac != null){

			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", ac);

			request.getRequestDispatcher("Adminhome.jsp").forward(request, response);
		}
		
	}

}
