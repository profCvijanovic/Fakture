package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinesService.RegistracijaLoginMetode;
import bussinesService.Validacija;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "servlet za log in", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password  = request.getParameter("password");
		
		String adminUserName = "prof.cvijanovic@gmail.com";
		String adminPassword = "nenadcv17";
		
		Validacija validacija = new Validacija();
		String sifraPassword = validacija.konvertujPasswordUSifru(password);
		
		RegistracijaLoginMetode rlm = new RegistracijaLoginMetode();
		boolean proveriUsera = rlm.daLiPostojiUser(userName);
		boolean proveriPassword = rlm.daLiJeDobarPassword(userName, sifraPassword);
		
		if(proveriUsera) {
			//proveri da li je password dobar
			if(proveriPassword) {
				//vrati usera sa datim user nameom i passwordom
				User user = rlm.vratiUsera(userName);
					if(user != null) {
						if(user.isAktivanUser()) {
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						if(user.getUserName().equals(adminUserName) && user.getPassword().equals(validacija.konvertujPasswordUSifru(adminPassword))) {
							response.sendRedirect("jsp/adminStrana.jsp");
						}else {
							response.sendRedirect("jsp/userStrana.jsp");
						}
						}else {
							response.sendRedirect("html/nisteJosAktivirani.html");
						}
					}else {
						response.sendRedirect("html/loginPonovo.html");
					}
			}else {
				response.sendRedirect("html/loginPonovo.html");
			}
		}else {
			response.sendRedirect("html/loginPonovo.html");
		}
		
	}

}
