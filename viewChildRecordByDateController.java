package intpattfyp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intpattfyp.dao.intpattfypDAO;

/**
 * Servlet implementation class viewChildRecordByDateController
 */
@WebServlet("/viewChildRecordByDateController")
public class viewChildRecordByDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	intpattfypDAO dao;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewChildRecordByDateController() {
    	super();
        dao = new intpattfypDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String selectDate = request.getParameter("selectDate");
		int childid = Integer.parseInt(request.getParameter("childid"));
		int parentid = Integer.parseInt(request.getParameter("parentid"));
		
		response.sendRedirect("viewchilddetailsByDate.jsp?childid="+childid+"&parentid="+parentid+"&selectDate="+selectDate);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
