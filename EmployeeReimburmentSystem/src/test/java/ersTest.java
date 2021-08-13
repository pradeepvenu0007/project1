import java.util.List;

import org.junit.Test;

import dao.daoImpl;
import entity.employeeEntity;
import entity.formEntity;
import junit.framework.TestCase;

public class ersTest extends TestCase {

	@Test
	public void testGetEmployee() {
		String user="pabarnatamil@gmail.com";
		daoImpl db=new daoImpl();
		
		employeeEntity e=db.getEmployee(user);
		assertNotNull(e);
	}
	
	@Test
	public void testallEmployee()
	{
daoImpl db=new daoImpl();
		
		List<employeeEntity> e=db.allEmployee();
		assertNotNull(e);
	}
	
	@Test
	public void testverifyLogin()
	{
		String user="pabarnatamil@gmail.com";
daoImpl db=new daoImpl();
		
		employeeEntity e=db.verifyLogin(user);
		assertNotNull(e);
	}
	@Test
	public void testpendingForm()
	{
		
daoImpl db=new daoImpl();
		
List<formEntity> e=db.pendingForm();
		assertNotNull(e);
	}
	@Test
	public void testpending()
	{
		String user="pabarnatamil@gmail.com";
daoImpl db=new daoImpl();
		
List<formEntity> e=db.pending(user);
		assertNotNull(e);
	}
	@Test
	public void testmanagerResolved()
	{
		
daoImpl db=new daoImpl();
		
List<formEntity> e=db.managerResolved();
		assertNotNull(e);
	}
	
	@Test
	public void testmanagerSolved()
	{
		String user="pabarnatamil@gmail.com";
daoImpl db=new daoImpl();
		
List<formEntity> e=db.solved(user);
		assertNotNull(e);
	}
	@Test
	public void testAccept()
	{
		
daoImpl db=new daoImpl();
		
db.accept(1);
			}
	@Test
	public void testreject()
	{
		
daoImpl db=new daoImpl();
		
db.reject(2);
			}
	
	
}
