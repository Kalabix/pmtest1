package service.managers;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.UserTable;

public class UserManager {
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    ServiceRegistry serviceRegistry;
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	private static SessionFactory factory=createSessionFactory();
			//Configuration config=new Configuration().configure().buildSessionFactory(); 
	public static void addUser(){
		 Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      UserTable user = new UserTable();
	         
	         user.setUserAddress("test");
	         user.setUserName("test");
	      try{
	         tx = session.beginTransaction();
	        
	         //employeeID = (Integer) session.save(user); 
	         session.persist(user);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
	}
	public static List getUser(){
		 Session session = factory.openSession();
		 
		Criteria u= session.createCriteria(UserTable.class);
		Query query = session.createQuery("from UserTable"); //You will get Weayher object
		List userInst=query.list();
		UserTable uu;
		//ser[] u1= (User[]) query.list();
		// User usr= (User) session.createCriteria(User.class).list();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	    	  uu=(UserTable) userInst.get(0);
	        // User user = tx.;
	         //employeeID = (Integer) session.save(user); 
	       
	        
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return userInst;
		
	}
	
	
}
