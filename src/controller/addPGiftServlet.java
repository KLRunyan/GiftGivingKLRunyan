package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonRecipient;
import model.PersonalGift;

/**
 * Servlet implementation class addPGiftServlet
 */
@WebServlet("/addPGiftServlet")
public class addPGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPGiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String birthDate = request.getParameter("birthDate");
		LocalDate bDate = LocalDate.parse(birthDate, formatter);
		String relationship = request.getParameter("relationship");
		
		PersonRecipient pr = new PersonRecipient(name, address, city, state, postalCode, bDate, relationship);
		PersonRecipientHelper precipienthelp = new PersonRecipientHelper();		
		precipienthelp.insertRecipient(pr);
		
		String date = request.getParameter("dateGiven");
		LocalDate dbDate = LocalDate.parse(date, formatter);
		String description = request.getParameter("description");
		String value = request.getParameter("value");
		double dValue = Double.parseDouble(value);
		String occasion = request.getParameter("occasion");
		
		PersonalGift pg = new PersonalGift(dbDate, description, dValue, pr, occasion);
		PersonalGiftHelper pgifthelp = new PersonalGiftHelper();
		pgifthelp.insertGift(pg);
		
		getServletContext().getRequestDispatcher("/addPersonalGift.html").forward(request, response);
	}

}
