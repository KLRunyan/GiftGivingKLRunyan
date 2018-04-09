package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharitableGift;
import model.CharityRecipient;

/**
 * Servlet implementation class editCGiftListServlet
 */
@WebServlet("/editCGiftListServlet")
public class editCGiftListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCGiftListServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		CharityRecipientHelper crecipienthelp = new CharityRecipientHelper();
		String act = request.getParameter("doThisToGift");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllCGiftsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Gift and Recipient")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			CharitableGift giftToDelete = cgifthelp.getGiftById(tempId);
			Integer tempRId = giftToDelete.getRecipient().getId();
			cgifthelp.deleteGift(giftToDelete);
			
			
			CharityRecipient cToDelete = crecipienthelp.getRecipientById(tempRId);
			crecipienthelp.deleteRecipient(cToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllCGiftsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Gift")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			CharitableGift giftToEdit = cgifthelp.getGiftById(tempId);
			request.setAttribute("cGiftToEdit", giftToEdit);
			getServletContext().getRequestDispatcher("/edit-cgift.jsp").forward(request, response);
		} else if (act.equals("Add New Gift")) {
			getServletContext().getRequestDispatcher("/addCharitableGift.html").forward(request, response);
		}


	}

}
