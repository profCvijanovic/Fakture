package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinesService.RegistracijaLoginMetode;
import bussinesService.Validacija;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "servlet za registraciju", urlPatterns = { "/RegistracioniServlet" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String kontaktTelefon = request.getParameter("kontaktTelefon");

		/*String imeFirme = request.getParameter("imeFirme");
		String pib = request.getParameter("pib");
		String maticniBroj = request.getParameter("maticniBroj");
		String drzava = request.getParameter("drzava");
		String grad = request.getParameter("grad");
		String ulica = request.getParameter("ulica");
		String postanskiBroj = request.getParameter("postanskiBroj");*/
		
		RegistracijaLoginMetode rlm = new RegistracijaLoginMetode();
		Validacija validacija = new Validacija();
		//konverzija passwordau sifru (md5)
		String sifraPassword = validacija.konvertujPasswordUSifru(password);
	
		boolean proveraUsera = rlm.daLiPostojiUser(userName);	
			if(proveraUsera) {
				response.sendRedirect("html/registracijaPonovo.html");
			}
		
		boolean b = rlm.upisiUseraUBazu(userName, sifraPassword, firstName, lastName,kontaktTelefon);
			if(b) {
				if(rlm.daLiJeAdmin(userName, sifraPassword)) {
					rlm.podesiAktivacijuAdmina(rlm.vratiUsera(userName));
				}
				response.sendRedirect("index.html");
			}else {
				response.sendRedirect("html/registracijaPonovoNeuspesanSaveUBazu.html");
			}		
	}

}
