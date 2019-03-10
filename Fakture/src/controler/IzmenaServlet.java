package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinesService.AdminMetode;
import model.User;

/**
 * Servlet implementation class IzmenaServlet
 */
@WebServlet(description = "admin izmene", urlPatterns = { "/IzmenaServlet" })
public class IzmenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String izaberi = request.getParameter("izaberi");
		String email = request.getParameter("email");
		String promena = request.getParameter("promena");
		
		AdminMetode admin = new AdminMetode();
		
		User userIzBaze = admin.vratiUseraPoMailu(email);
		
		if(userIzBaze != null) {
			if(izaberi.equals("userName")) {
				if(admin.azurirajEmail(userIzBaze, promena)) {
					response.sendRedirect("jsp/adminStrana.jsp");
				}else {
					response.sendRedirect("jsp/error.jsp");
				}
			}
			
		}else {
			response.sendRedirect("jsp/error.jsp");
		}
	}
	
	
	
	
	
	
}
