package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bussinesService.Validacija;
import model.Admin;

/**
 * Servlet implementation class MailDispatcherServlet
 */
@WebServlet(description = "servlet za slanje maila", urlPatterns = { "/MailDispatcherServlet" })
public class MailDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Validacija senderBean = new Validacija();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String toEmail = (String)request.getAttribute("email");
		String subject = "Potvrda registracije";
		String message = "Nalog ce vam biti aktiviran cim admin odobri.Hvala sto koristite nas program.";
		String subjectAdmin = "Novi korisnik zeli da se registruje ";
		String messageAdmin = "Korisnik " + toEmail + " zeli da ga registrujete";
		
		PrintWriter out = response.getWriter();
		
		senderBean.sendRegistrationEmail(Admin.getAdminusername(), Admin.getAdminpassword(), toEmail, subject, message);
		senderBean.sendRegistrationEmail(Admin.getAdminusername(), Admin.getAdminpassword(), Admin.getAdminusername(), subjectAdmin, messageAdmin);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>mail</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Mail Status");
		out.println("Poslat vam je aktivacioni email kliknite <a href='index.html'>back</a> kako biste se vratili na pocetnu stranu  ");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
