package staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staff.dao.*;

/**
 * Servlet implementation class ViewStaffController
 */
@WebServlet("/ViewStaffController")
public class ViewStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("s",StaffDAO.getStaffById(id));
		RequestDispatcher view = request.getRequestDispatcher("viewStaff.jsp");
		view.forward(request, response);
	}

}
