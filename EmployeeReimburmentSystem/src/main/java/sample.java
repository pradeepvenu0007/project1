

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.ImageWrapper;

/**
 * Servlet implementation class sample
 */
@WebServlet("/sample")
public class sample extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		 
		ImageWrapper imgNew = (ImageWrapper)session.get(ImageWrapper.class, 1);
		byte[] rb = imgNew.getData();
		 
		try{
//		    FileOutputStream fos = new FileOutputStream("C:\\temp\\test.png"); 
//		    fos.write(bAvatar);
//		    fos.close();
			response.reset();
			  response.setContentType("image/jpg");
			  response.getOutputStream().write(rb);
			  response.getOutputStream().flush();  
		}catch(Exception e){
		    e.printStackTrace();
		}
		 
		session.getTransaction().commit();

	}

}
