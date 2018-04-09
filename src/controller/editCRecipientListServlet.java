package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharityRecipient;

/**
 * Servlet implementation class editCRecipientListServlet
 */
@WebServlet("/editCRecipientListServlet")
public class editCRecipientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editCRecipientListServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CharityRecipientHelper crecipienthelp = new CharityRecipientHelper();	
		String act = request.getParameter("doThisToCRecipient");

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllCRecipientsServlet").forward(request, response);
		
		} else if (act.equals("Edit Selected Recipient")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			CharityRecipient cRecipientToEdit = crecipienthelp.getRecipientById(tempId);
			request.setAttribute("cRecipientToEdit", cRecipientToEdit);
			getServletContext().getRequestDispatcher("/edit-crecipient.jsp").forward(request, response);
		}
	}
}