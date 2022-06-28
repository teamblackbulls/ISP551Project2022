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
 * Servlet implementation class ListPrayerController
 */
@WebServlet("/ListPrayerController")
public class ListPrayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrayerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPrayerController() {
        super();
        dao = new PrayerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("prayers", PrayerDAO.getAllPrayers());
		RequestDispatcher view = request.getRequestDispatcher("listPrayer.jsp");
		view.forward(request, response);
	}


}
