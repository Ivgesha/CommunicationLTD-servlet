import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordClass extends HttpServlet{
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	
	public ChangePasswordClass () {
		System.out.println("entered ChangePasswordClass  c'tor\n");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String submitButton = (String)request.getParameter("btnSubmit");
		
		
		if("submit".equals(submitButton)) {
			dispatcher = request.getRequestDispatcher("/views/SystemPage.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
	}
	
	
}
