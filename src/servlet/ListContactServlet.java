package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Contact;
import service.ContactService;
import serviceImpl.ContactServiceImpl;


@WebServlet("/")
public class ListContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ContactService service = new ContactServiceImpl();
		
		List<Contact> allContact = service.findAllContact();
		request.setAttribute("contacts", allContact);
		request.getRequestDispatcher("/listContact.jsp").forward(request, response);		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
