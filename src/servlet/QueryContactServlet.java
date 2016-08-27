package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Contact;
import service.ContactService;
import serviceImpl.ContactServiceImpl;

/**
 * Servlet implementation class QueryContactServlet
 */
@WebServlet("/QueryContactServlet")
public class QueryContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.����id
		String id = request.getParameter("id");
		//2.����service����id��ѯ��ϵ�˵ķ���
		ContactService service = new ContactServiceImpl();
		Contact contact = service.findById(id);
		
		//3.�Ѳ�ѯ�Ľ�����浽request����
		request.setAttribute("contact", contact);
		//4.��ת���޸���ϵ�˵�ҳ��
		request.getRequestDispatcher("/updateContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
