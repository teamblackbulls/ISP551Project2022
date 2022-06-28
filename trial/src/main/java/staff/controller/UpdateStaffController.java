package staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staff.dao.*;
import staff.model.*;

/**
 * Servlet implementation class UpdateStaffController
 */
@WebServlet("/UpdateStaffController")
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffController() {
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
		request.setAttribute("s", StaffDAO.getStaffById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateStaff.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Staff s = new Staff();
		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		s.setPhone(request.getParameter("phone"));
		s.setEmail(request.getParameter("email"));
		s.setRole(request.getParameter("role"));
		
		
		dao.updateStaff(s);
		
		request.setAttribute("staffs", StaffDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request, response);
	}

}
