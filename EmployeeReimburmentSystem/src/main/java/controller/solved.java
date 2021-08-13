package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.TypedQuery;
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
import entity.formEntity;

/**
 * Servlet implementation class solved
 */
@WebServlet("/solved")
public class solved extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Cookie ck[]=request.getCookies();  
//		String user=ck[0].getValue();
		HttpSession ses=request.getSession(false);
		String user=(String)ses.getAttribute("user");
//
//		String q="From formEntity f where employee=\'"+user+"\' AND status IS NOT NULL";
//		TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
		daoImpl db=new daoImpl();
		List<formEntity> form = db.solved(user);//query.getResultList();
		RequestDispatcher rd=request.getRequestDispatcher("menubar.html");  
        rd.include(request, response);
        response.getWriter().append("Solved Reimbursement Form");
		response.setContentType("text/html");  
				
		if (form.isEmpty()) {
			out.print("NO RECORDS...");
			
		} else {

		
		
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "            margin-top: 7rem;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        table {\r\n"
				+ "            margin: 0 auto;\r\n"
				+ "            font-family: arial, sans-serif;\r\n"
				+ "            width: 90%;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        th,\r\n"
				+ "        td {\r\n"
				+ "            border: 2px solid black;\r\n"
				+ "            text-align: center;\r\n"
				+ "            padding: 15px;\r\n"
				+ "            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        tr {\r\n"
				+ "            background-color: rgb(255, 250, 231);\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body style=\"background-color: white;\">\r\n"
				+ "\r\n"
				+ "    <div>\r\n"
				+ "\r\n"
				+ "        <table>\r\n"
				+ "            <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                    <th>ID</th>\r\n"
				+ "                    <th>Claim type</th>\r\n"
				+ "                    <th>Requested Amount</th>\r\n"
				+ "                    <th>Description</th>\r\n"
				+ "                    <th>Request Status</th>\r\n"
				+ "                </tr>\r\n"
				+ "\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>\r\n"
				+ "");
		for(formEntity e:form) 
		{
			out.println("<tr>\r\n"
					+ "                    <td>"+e.getId()+"</td>\r\n"
					+ "                    <td>"+e.getType()+"</td>\r\n"
					+ "                    <td>"+e.getAmount()+"</td>\r\n"
					+ "                    <td>"+e.getDescription()+"</td>\r\n"
							+ "                    <td>"+e.getStatus()+"</td>\r\n"
					+ "                </tr>");
		}
		out.println("</tbody>\r\n"
				+ "        </table>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
		}
	}

}
