package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import db.EmployeeMapper;
import db.formMapper;
import entity.employeeEntity;
import entity.formEntity;
import model.Employee;
import model.reimbursementform;

public class daoImpl {
	public void addEmployee(Employee e)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();  
		session.save(EmployeeMapper.mapEmployee(e));
		System.out.println("employee inserted...");
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	public employeeEntity getEmployee( String user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session=sessionFactory.openSession();
	employeeEntity a=new employeeEntity();
	session.load(a,user);
		session.close();
		sessionFactory.close();
		return a;
	}
	public List<employeeEntity> allEmployee()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		List<employeeEntity> list=new ArrayList<employeeEntity>();
		Query q=session.createQuery("from employeeEntity e");
		list=q.list();
		session.close();
		sessionFactory.close();
		return list;
	}
	public void addForm(reimbursementform f)
	{
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			
			session.beginTransaction();  
			session.save(formMapper.map(f));
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
	}
	public employeeEntity verifyLogin( String user)
	{
		employeeEntity a=new employeeEntity();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		a=(employeeEntity)session.get(employeeEntity.class,user);
		session.close();
		sessionFactory.close();
		return a;
	}
	public List<formEntity> pendingForm()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		String q="From formEntity f where status IS NULL";
		TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
		List<formEntity> form = query.getResultList();
		session.close();
		sessionFactory.close();
		return form;
	}
	public List<formEntity> pending(String user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		String q="From formEntity f where employee=\'"+user+"\' AND status IS NULL";
		TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
		List<formEntity> form = query.getResultList();
		session.close();
		sessionFactory.close();
		return form;
	}
	public List<formEntity> managerResolved()
	{
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			String q="From formEntity f where status IS NOT NULL";
			TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
			List<formEntity> form = query.getResultList();
			session.close();
			sessionFactory.close();
			return form;
	}
	public List<formEntity> solved(String user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();

		String q="From formEntity f where employee=\'"+user+"\' AND status IS NOT NULL";
		TypedQuery<formEntity> query = session.createQuery(q, formEntity.class);
		List<formEntity> form = query.getResultList();
		session.close();
		sessionFactory.close();
		return form;
	}
	public void accept(int id)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		formEntity f=new formEntity();
		f=session.load(formEntity.class,id);
		f.setStatus("Accepted");
		 session.update(f);
	        tx.commit();
	        session.close();
	}
	public void reject(int id)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		formEntity f=new formEntity();
		f=session.load(formEntity.class,id);
		f.setStatus("Rejected");
		 session.update(f);
	        tx.commit();
	        session.close();
	}
	public employeeEntity update(String user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		employeeEntity a=new employeeEntity(); 
		session.load(a,user);
		session.close();
		sessionFactory.close();
		return a;
	}
}


