package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinesService.UserMetode;
import model.Firma;
import model.Klijent;

/**
 * Servlet implementation class DodajKlijentaServlet
 */
@WebServlet(description = "servlet za dodavanje klijenta", urlPatterns = { "/DodajKlijentaServlet" })
public class DodajKlijentaServlet extends HttpServlet {
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
		String firme = request.getParameter("firme");
		
		UserMetode userMetode = new UserMetode();
		Firma firma = userMetode.vratiFirmuPoImenuFirme(firme);
			if(firma!=null) {
				boolean b = userMetode.upisiKlijentaUBazu(imeFirme, pib, maticniBrojFirme, drzava, grad, ulica, postanskiBroj,firma.getIdFirme());
					if(b) {
						boolean d = userMetode.dodajKlijentaFirmi(firma.getIdFirme(), imeFirme);
							if(d) {
								response.sendRedirect("jsp/userStrana.jsp");
							}else {
								response.sendRedirect("jsp/errorUser.jsp");
							}
					}else {
						response.sendRedirect("jsp/errorUser.jsp");
					}
			}else {
				response.sendRedirect("jsp/errorUser.jsp");
			}
		
	}

}
