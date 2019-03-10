package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinesService.AdminMetode;

/**
 * Servlet implementation class AktivirajUseraServlet
 */
@WebServlet(description = "servlet za aktiviranje usera", urlPatterns = { "/AktivirajUseraServlet" })
public class AktivirajUseraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		AdminMetode adminMetode = new AdminMetode();
		
		boolean aktiviraj = adminMetode.aktivirajUsera(email);
		
		if(aktiviraj) {
			response.sendRedirect("jsp/uspesnaAktivacijaUsera.jsp");
		}else {
			response.sendRedirect("jsp/error.jsp");
		}
		
		
	}

}
