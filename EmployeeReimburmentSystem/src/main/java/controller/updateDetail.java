package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.employeeEntity;

@WebServlet("/updateDetail")
public class updateDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 PrintWriter out = response.getWriter(); 
		 
//		 Cookie ck[]=request.getCookies();  
//			String employee=ck[0].getValue();
 HttpSession ses=request.getSession(false);
	String user=(String)ses.getAttribute("user");
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				employeeEntity e=new employeeEntity(); 
				session.load(e,user);
				e.setName(request.getParameter("name"));	
				e.setEmail(request.getParameter("email"));
				e.setAddress(request.getParameter("address"));
				e.setMobile(request.getParameter("mobile"));
				e.setDepartment(request.getParameter("department"));
				e.setDesignation(request.getParameter("designation"));
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
								+ "    <strong>Success!!!</strong> Profile Updated\r\n"
								+ "  </div>\r\n"
								+ "\r\n"
								+ "\r\n"
								+ "</body>\r\n"
								+ "</html>\r\n"
								);
				        RequestDispatcher rd=request.getRequestDispatcher("home");  
				        rd.include(request, response);
	}

}
