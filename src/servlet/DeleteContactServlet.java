package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactService;
import serviceImpl.ContactServiceImpl;


/**
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.接收id
		String id = request.getParameter("id");
		
		//2.调用service删除联系人的方法
		ContactService service = new ContactServiceImpl();
		service.deleteContactById(id);
		
		//3.跳转到查询联系人的页面
		response.sendRedirect(request.getContextPath()+"/ListContactServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
