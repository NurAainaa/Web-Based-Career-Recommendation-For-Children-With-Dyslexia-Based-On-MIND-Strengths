package intpattfyp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intpattfyp.connection.ConnectionManager;
import intpattfyp.dao.intpattfypDAO;
import intpattfyp.model.adminacc;
import intpattfyp.model.parent_tutor;

/**
 * Servlet implementation class updateUserPassController
 */
@WebServlet("/updateUserPassController")
public class updateUserPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserPassController() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String password = request.getParameter("newpass");
		
		intpattfypDAO cm = new intpattfypDAO();
		parent_tutor pt = null;
		adminacc ac = null;
		
		try {
			pt = cm.checkParentID(email,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ac = cm.checkAdminId(email,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (pt != null) {
			parent_tutor ptt = new parent_tutor();
			ptt.setId(id);
			ptt.setPassword(password);
			dao.updateTutorPass(ptt);
		}
		
		if (ac != null) {
			adminacc acc = new adminacc();
			acc.setId(id);
			acc.setPassword(password);
			dao.updateAdminPass(acc);
		}
		
		request.getRequestDispatcher("loginAfterUpdatePassword.jsp").forward(request, response);
	}

}
