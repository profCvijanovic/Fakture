package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		RequestDispatcher dispatcher;
		
		if(proveriUsera) {
			//proveri da li je password dobar
			if(proveriPassword) {
				//vrati usera sa datim user nameom i passwordom
				User user = rlm.vratiUsera(userName);
					if(user != null) {
						if(user.getUserName().equals(adminUserName) && user.getPassword().equals(validacija.konvertujPasswordUSifru(adminPassword))) {
							request.setAttribute("user", user);
							dispatcher = request.getRequestDispatcher("jsp/adminStrana.jsp");
							dispatcher.forward(request, response);
						}else {
							request.setAttribute("user", user);
							dispatcher = request.getRequestDispatcher("jsp/userStrana.jsp");
							dispatcher.forward(request, response);
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
