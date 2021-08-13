package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.daoImpl;
import entity.employeeEntity;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger("login.class");
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		employeeEntity a=new employeeEntity(); 
//		
//			
//		
//		a=(employeeEntity)session.get(employeeEntity.class,user);
		    employeeEntity a=new employeeEntity(); 
		    daoImpl db=new daoImpl();
		    a=db.verifyLogin(user);
		    logger.info("verifing user");
	if (password.equals(a.getPassword())) 
	{
		logger.info("password matched");
		HttpSession ses=request.getSession();
		ses.setAttribute("user",user);
		
        if(a.getType().equals("employee"))
        {
        	
        	RequestDispatcher rd2=request.getRequestDispatcher("/home");  
            rd2.forward(request, response);
        }
        else
        {
        	
        	RequestDispatcher rd2=request.getRequestDispatcher("/managerHome");  
            rd2.forward(request, response);
        }
        	
	} 
	else
	{
		logger.info("login authentication failed");
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
				+ "    <strong>oops!!!</strong> Invalid Username or Password.\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				);
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request, response);  
		
	}
	}

}
