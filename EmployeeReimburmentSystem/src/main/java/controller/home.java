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

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.daoImpl;
import entity.employeeEntity;

@WebServlet("/home")
public class home extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie ck[]=request.getCookies();  
//		String user=ck[0].getValue();
		HttpSession ses=request.getSession(false);
		String user=(String)ses.getAttribute("user");
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		employeeEntity a=new employeeEntity(); 
//		session.load(a,user);
		Logger logger = Logger.getLogger("home.class");
		logger.info("Employee home page");
		daoImpl obj=new daoImpl();
		employeeEntity a=obj.getEmployee(user);
		 response.setContentType("text/html"); 
		 RequestDispatcher rd=request.getRequestDispatcher("menubar.html");  
	        rd.include(request, response);
		    PrintWriter out = response.getWriter(); 
		    
		    out.println("<!DOCTYPE html>\r\n"
		    		+ "<html>\r\n"
		    		+ "\r\n"
		    		+ "<head>\r\n"
		    		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
		    		+ "    <link rel=\"stylesheet\" href=\"profile.css\">\r\n"
		    		
		    		+ "</head>\r\n"
		    		+ "\r\n"
		    		+ "<body>\r\n"
		    		+ "\r\n"
		    		+ "    <h2 style=\"text-align:center\">"+a.getType()+"</h2>\r\n"
		    		+ "\r\n"
		    		+ "    <div class=\"card\">\r\n"
		    		+ "        <img src=\"image.jpg\" alt=\"Profile\" style=\"width:70%\">\r\n"
		    		+"<h3>Name:</h3><h5>"+a.getName()+"</h4>"
		    		+"<h3>Email:</h3><h5>"+a.getEmail()+"</h4>"
		    		+"<h3>Department:</h3><h5>"+a.getDepartment()+"</h4>"
		    		+"<h3>Designation:</h3><h5>"+a.getDesignation()+"</h4>"
		    		+"<h3>Address for communication:</h3><h5>"+a.getAddress()+"</h4>"
		    		+"<h3>Mobile:</h3><h5>"+a.getMobile()+"</h4>"
		    		+ "       \r\n"
		    		+ "       \r\n"
		    		+ "    </div>\r\n"
		    		+ "\r\n"
		    		+ "</body>\r\n"
		    		+ "\r\n"
		    		+ "</html>");
		  //  session.close();
		    
		    
		    
		    

		    
	}

}
