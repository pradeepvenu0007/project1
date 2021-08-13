package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


@WebServlet("/logout")
public class logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 Cookie ck[]=request.getCookies();  
//		 ck[0].setMaxAge(0);
		Logger logger = Logger.getLogger("logout.class");
		logger.info("Userlogout");
		HttpSession ses=request.getSession();
		ses.invalidate();
		   RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		   rd.forward(request, response);
	}

}
