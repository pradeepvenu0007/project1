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
import org.hibernate.cfg.Configuration;

import dao.daoImpl;
import entity.employeeEntity;

@WebServlet("/update")
public class update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter(); 
		 
//		 Cookie ck[]=request.getCookies();  
//			String employee=ck[0].getValue();
			HttpSession ses=request.getSession(false);
			String user=(String)ses.getAttribute("user");
//
//			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//				Session session=sessionFactory.openSession();
//				employeeEntity a=new employeeEntity(); 
//				session.load(a,user);
			  daoImpl db=new daoImpl();
			employeeEntity a=db.update(user);
			
			RequestDispatcher rd=request.getRequestDispatcher("menubar.html");  
		    rd.include(request, response);
		    out.println("<form action=\"updateDetail\" >"
				+ "<div>	<label >Name</label>\r\n"
				+ "					<input  name=\"name\" type=\"text\" value=\""+a.getName()+"\" required>"
				+"<div></div><br><label >Email Address</label>\r\n"
				+ "					<input  name=\"email\" type=\"text\" value=\""+a.getEmail()+"\" required>"
				+"<div></div><br><label >Mobile Number</label>\r\n"
				+ "				<input type=\"tel\" name=\"mobile\"  pattern=\"[0-9]{10}\" value=\""+a.getMobile()+"\" required>"
				+"<div></div><br><label >Department</label>\r\n"
				+ "					<input  name=\"department\" type=\"text\" value=\""+a.getDepartment()+"\" required>"
				+"<div></div>	<br><label >Designation</label>\r\n"
				+ "					<input  name=\"designation\" type=\"text\" value=\""+a.getDesignation()+"\" required>"
				+"<div></div><br>	<label >Address</label>\r\n"
				+ "					<input  name=\"address\" type=\"text\" value=\""+a.getAddress()+"\" required>"
				+"<div>"
				+ "					<input type=\"submit\"  value=\"Update\">\r\n"
				+ "				</div>");
	}


}
