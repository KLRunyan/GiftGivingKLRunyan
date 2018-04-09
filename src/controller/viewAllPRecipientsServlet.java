package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonRecipient;

/**
 * Servlet implementation class viewAllPRecipientsServlet
 */
@WebServlet("/viewAllPRecipientsServlet")
public class viewAllPRecipientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewAllPRecipientsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PersonRecipientHelper phelp = new PersonRecipientHelper();
		List<PersonRecipient> recipients = phelp.getRecipients();
		System.out.println(recipients);
		request.setAttribute("personList",recipients);
		

		if (recipients.isEmpty()){
			request.setAttribute("personList", " ");
		}
		getServletContext().getRequestDispatcher("/precipient-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}