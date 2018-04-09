package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharitableGift;


/**
 * Servlet implementation class viewAllGiftsServlet
 */
@WebServlet("/viewAllCGiftsServlet")
public class viewAllCGiftsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewAllCGiftsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
			
		List<CharitableGift> gifts = cgifthelp.getGifts();
		request.setAttribute("giftList", gifts);

		if (gifts.isEmpty()) {
			request.setAttribute("giftList", " ");
		}

		getServletContext().getRequestDispatcher("/charitablegift-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
