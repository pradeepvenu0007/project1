package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.daoImpl;
import db.EmployeeMapper;
import model.Employee;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		//response.getWriter().append("registration");
		Logger logger = Logger.getLogger("reg.class");
		logger.info("Employee registration started");
		 PrintWriter out = response.getWriter();
		 e.setName(request.getParameter("name"));
		 e.setEmail(request.getParameter("email"));
		 e.setPassword(request.getParameter("password"));	
		 e.setType(request.getParameter("type"));
		e.setAddress(request.getParameter("address"));
		e.setMobile(request.getParameter("mobile"));
		e.setDepartment(request.getParameter("department"));
		e.setDesignation(request.getParameter("designation"));
		daoImpl db=new daoImpl();
		db.addEmployee(e);
		RequestDispatcher rd2=request.getRequestDispatcher("index.html");  
        rd2.forward(request, response);
        logger.info("Registration successful");
	
	}

}
