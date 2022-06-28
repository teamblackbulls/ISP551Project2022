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
 * Servlet implementation class AddStaffController
 */
@WebServlet("/AddStaffController")
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Staff s = new Staff();		
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		s.setPhone(request.getParameter("phone"));
		s.setEmail(request.getParameter("email"));
		s.setRole(request.getParameter("role"));
		
		
		dao.addStaff(s); //invoke method addStaff() in StaffDAO
		
		request.setAttribute("staffs",StaffDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request, response);
	}

}
