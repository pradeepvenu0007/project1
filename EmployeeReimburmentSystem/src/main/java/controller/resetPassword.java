package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.employeeEntity;

/**
 * Servlet implementation class resetPassword
 */
@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter(); 
		String current=request.getParameter("current");
		String renew = request.getParameter("new");
		HttpSession ses=request.getSession(false);
		String user=(String)ses.getAttribute("user");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Logger logger = Logger.getLogger("resetPassword");
		logger.info("Password reset initiated");
		employeeEntity e=new employeeEntity(); 
		session.load(e,user);
		if(current.equals(e.getPassword()))
		{
			Transaction tx = session.beginTransaction();
			e.setPassword(renew);
			session.update(e);
	        tx.commit();
	        session.close();
	    	out.print("\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "  <title>Bootstrap Example</title>\r\n"
					+ "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
					+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
					+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "  <div class=\"alert alert-success\">\r\n"
					+ "    <strong>Success!!!</strong> Password reseted\r\n"
					+ "  </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					);
	    	logger.info("Password reset Successful");
	        RequestDispatcher rd=request.getRequestDispatcher("home");  
	        rd.include(request, response);
		}
		else
		{
			 session.close();
			out.print("\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "  <title>Bootstrap Example</title>\r\n"
					+ "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
					+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
					+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "  <div class=\"alert alert-danger\">\r\n"
					+ "    <strong>Failed!!!</strong> Invalid password\r\n"
					+ "  </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					);
			logger.info("Password reset failed");
	        RequestDispatcher rd=request.getRequestDispatcher("home");  
	        rd.include(request, response);
		}
		
						
		
	}

}
