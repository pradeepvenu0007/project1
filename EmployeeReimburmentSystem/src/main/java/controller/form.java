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
import db.EmployeeMapper;
import db.formMapper;
import model.reimbursementform;


@WebServlet("/form")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("form.class");
		logger.info("Form submission initiated");
		String claim=request.getParameter("type");
		String amount=request.getParameter("amount");
		String description=request.getParameter("description");
//		Cookie ck[]=request.getCookies();  
//		String employee=ck[0].getValue();
		HttpSession ses=request.getSession(false);
		String user=(String)ses.getAttribute("user");

		PrintWriter out = response.getWriter();
		
		reimbursementform f=new reimbursementform();
		f.setAmount(amount);
		f.setDescription(description);
		f.setEmployee(user);
		f.setType(claim);
		daoImpl db=new daoImpl();
		db.addForm(f);
//		 try {
//			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//				Session session=sessionFactory.openSession();
//				//session i sused for communicating with db
//				session.beginTransaction();  //insert,update,delete,  not required for select
//				session.save(formMapper.map(f));
//				//System.out.println("form inserted inserted...");
//				session.getTransaction().commit();
//				session.close();

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
						+ "    Claim summited successfully.\r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						);
				
				logger.info("Form submiteed successfully");
				   RequestDispatcher rd=request.getRequestDispatcher("/home");  
rd.include(request, response);
				
				
//			} catch (Exception e1) {
//				
//				e1.printStackTrace();
//			}
	
		
        
		//out.println(ck[0].getValue());  
	}

}
 