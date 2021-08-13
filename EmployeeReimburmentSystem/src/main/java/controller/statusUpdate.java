package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.daoImpl;
import entity.employeeEntity;
import entity.formEntity;

@WebServlet("/statusUpdate")
public class statusUpdate extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int id=Integer.valueOf(request.getParameter("id"));
		daoImpl db=new daoImpl();
		if(request.getParameter("status").equals("Accepted"))
		{
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		formEntity f=new formEntity();
//		f=session.load(formEntity.class,id);
//		f.setStatus("Accepted");
//		 session.update(f);
//	        tx.commit();
//	        session.close();
			
			db.accept(id);
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
					+ "    <strong>Request Accepted</strong>\r\n"
					+ "  </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					);
		}		
		else
		{
//			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//			Session session=sessionFactory.openSession();
//			Transaction tx = session.beginTransaction();
//			formEntity f=new formEntity();
//			f=session.load(formEntity.class,id);
//			f.setStatus("Rejected");
//			 session.update(f);
//		        tx.commit();
//		        session.close();
			db.reject(id);
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
						+ "    <strong>Request Denied</strong> \r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						);
		      
		}
		  RequestDispatcher rd=request.getRequestDispatcher("/managerPending");  
	        rd.include(request, response);
	}

}
