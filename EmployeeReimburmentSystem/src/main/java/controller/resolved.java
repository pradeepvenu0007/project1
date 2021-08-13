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
import entity.employeeEntity;
import entity.formEntity;

@WebServlet("/resolved")
public class resolved extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("managermenu.html");  
	    rd.include(request, response);
	    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
//		Cookie ck[]=request.getCookies();  
//		String user=ck[0].getValue();
//		HttpSession ses=request.getSession(false);
//		String user=(String)ses.getAttribute("user");
//		String q="From formEntity f where status IS NOT NULL";
//		TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
		daoImpl db=new daoImpl();
		List<formEntity> form = db.managerResolved();//query.getResultList();
		 response.getWriter().append("Solved Reimbursement Form");
		response.setContentType("text/html");  

		
		if (form.isEmpty()) {
			out.print("NO RECORDS...");
			
		} else {

		

			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"table.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"button.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<h2>Resolved Reimbursement details</h2>\r\n"
					+ "\r\n"
					+ "<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"Search for names..\" title=\"Type in a name\">\r\n"
					+ "\r\n"
					+ "<table id=\"myTable\">\r\n"
					+ "  <tr class=\"header\">\r\n"
					+ "    <th style=\"width:auto;\">Employee Name </th>\r\n"
					+ "    <th style=\"width:auto;\">Employee details</th>\r\n"
					+ "    <th style=\"width:auto;\">Reimbursement Details</th>\r\n"
					+ "    <th style=\"width:auto;\">Response</th>\r\n"
					+ "  </tr>");
			
			for(formEntity e:form) 
			{
//				Session session2=sessionFactory.openSession();
//				employeeEntity a=new employeeEntity(); 
//				session2.load(a,e.getEmployee());
//				System.out.println(a);
				employeeEntity a=db.getEmployee(e.getEmployee());
				
				out.println("<tr>\r\n"
						
						+"<td> <p>"+a.getName()
						+"</td><td></p><p>Type: "+a.getDesignation()
						+"</p><p>Department: "+a.getDepartment()
						+"</p></td>"
						
						+ "<td>"
						+ "<p>Form Id: "+e.getId()
						+"</p><p>Type: "+e.getType()
						+"</p><p>Amount: "+e.getAmount()
						+"</p><p>Description: "+e.getDescription()
						
												
						+"</p></td>"
						+ "    <td>"
						+e.getStatus()
						+"</td>"
						
						
						);
				//session2.close();
			}
			
			out.println("\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "<script>\r\n"
					+ "function myFunction() {\r\n"
					+ "  var input, filter, table, tr, td, i, txtValue;\r\n"
					+ "  input = document.getElementById(\"myInput\");\r\n"
					+ "  filter = input.value.toUpperCase();\r\n"
					+ "  table = document.getElementById(\"myTable\");\r\n"
					+ "  tr = table.getElementsByTagName(\"tr\");\r\n"
					+ "  for (i = 0; i < tr.length; i++) {\r\n"
					+ "    td = tr[i].getElementsByTagName(\"td\")[0];\r\n"
					+ "    if (td) {\r\n"
					+ "      txtValue = td.textContent || td.innerText;\r\n"
					+ "      if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n"
					+ "        tr[i].style.display = \"\";\r\n"
					+ "      } else {\r\n"
					+ "        tr[i].style.display = \"none\";\r\n"
					+ "      }\r\n"
					+ "    }       \r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "</script>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
	}

	
	}
}
