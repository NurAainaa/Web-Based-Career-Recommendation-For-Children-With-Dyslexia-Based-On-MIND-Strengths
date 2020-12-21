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
 * Servlet implementation class updatecareercontroller
 */
@WebServlet("/updatecareercontroller")
public class updatecareercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecareercontroller() {
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
		
		career c = new career();
		c.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		c.setCarrerid(Integer.parseInt(request.getParameter("careerid")));
		c.setCarrernme(request.getParameter("careernme"));
		c.setCataid(Integer.parseInt(request.getParameter("cataid")));
		dao.updatecareer(c);

		
		response.sendRedirect("AdminhomeAfterUpdateCareer.jsp");
	}

}
