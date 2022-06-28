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
 * Servlet implementation class AddPrayerController
 */
@WebServlet("/AddPrayerController")
public class AddPrayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrayerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrayerController() {
        super();
        dao = new PrayerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Prayer p = new Prayer();		
		p.setPrayerName(request.getParameter("prayerName"));

		dao.addPrayer(p); //invoke method addStaff() in StaffDAO
		
		request.setAttribute("prayers",PrayerDAO.getAllPrayers());
		RequestDispatcher view = request.getRequestDispatcher("listPrayer.jsp");
		view.forward(request, response);
	}

}
