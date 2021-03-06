package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharityRecipient;

/**
 * Servlet implementation class editCRecipientServlet
 */
@WebServlet("/editCRecipientServlet")
public class editCRecipientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCRecipientServlet() {
        super();
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
		CharityRecipientHelper crecipienthelp = new CharityRecipientHelper();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String taxId = request.getParameter("taxId");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CharityRecipient cRecipientToEdit = crecipienthelp.getRecipientById(tempId);
		
		cRecipientToEdit.setName(name);
		cRecipientToEdit.setStreetAddress(address);
		cRecipientToEdit.setCity(city);
		cRecipientToEdit.setState(state);
		cRecipientToEdit.setPostalCode(postalCode);
		cRecipientToEdit.setTaxId(taxId);
		
		crecipienthelp.editRecipient(cRecipientToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllCRecipientsServlet").forward(request, response);
			
		doGet(request, response);
	}

}
