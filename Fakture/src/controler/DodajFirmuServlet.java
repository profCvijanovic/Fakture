package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinesService.UserMetode;
import model.Firma;
import model.User;

/**
 * Servlet implementation class DodajFirmuServlet
 */
@WebServlet(description = "dodavanje firmi useru", urlPatterns = { "/DodajFirmuServlet" })
public class DodajFirmuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imeFirme = request.getParameter("imeFirme");
		String pib = request.getParameter("pib");
		String maticniBrojFirme = request.getParameter("maticniBrojFirme");
		String drzava = request.getParameter("drzava");
		String grad = request.getParameter("grad");
		String ulica = request.getParameter("ulica");
		String postanskiBroj = request.getParameter("postanskiBroj");
		
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		
		UserMetode userMetode = new UserMetode();
		if(user != null) {
			boolean b = userMetode.dodajFirmuUBazu(imeFirme, pib, maticniBrojFirme, drzava, grad, ulica, postanskiBroj, user.getUserId());
			if(b) {
				boolean d = userMetode.dodajFirmuUseru(user.getUserId(), imeFirme);
					if(d) {
						response.sendRedirect("jsp/userStrana.jsp");
					}else {
						response.sendRedirect("jsp/errorUser.jsp");
					}
				
			}else {
				response.sendRedirect("jsp/errorUser.jsp");
			}
		}else {
			System.out.println("Nije prosledjen user");
			response.sendRedirect("jsp/errorUser.jsp");
		}
			
	}

}
