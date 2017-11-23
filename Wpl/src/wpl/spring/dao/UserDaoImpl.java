package wpl.spring.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.User;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired 
	private SessionFactory sessionFactory;
	
/*	
	public void addUser(User bean){
		  
		    Session currentSession = sessionFactory.getCurrentSession();
	    	//Session session = HibernateUtil.getSessionFactory().openSession();
	    	//session.beginTransaction();

	        currentSession.save( bean );

		   // session.getTransaction().commit();

		   // get a new EM to make sure data is actually retrieved from the store and not Hibernate's internal cache
		  //  session.close();
	        
	    }*/
	  
	  	@Override
	    public void updateUser(User user) {
	    	//Session currentSession = HibernateUtil.getSessionFactory().openSession();
	    	//currentSession.beginTransaction();

	    	Session currentSession = sessionFactory.getCurrentSession();
	    	System.out.println(user.getFirstName());
		    String stringQuery = "UPDATE User SET FirstName= :firstname, LastName= :lastname, SecurityQuestion= :securityquestion, "
		    		+ "SecurityAnswer= :securityanswer, Password= :password  WHERE EmailID= '"+user.getEmail()+"'";
		    Query query = currentSession.createQuery(stringQuery);
		    query.setParameter("firstname", user.getFirstName());
		    query.setParameter("lastname", user.getLastName());
		    query.setParameter("securityquestion", user.getSecurityQuestion());
		    query.setParameter("securityanswer", user.getSecurityAnswer());
		    query.setParameter("password", user.getPassword());
		    query.executeUpdate();
		    
		   // currentSession.getTransaction().commit();

		    // get a new EM to make sure data is actually retrieved from the store and not Hibernate's internal cache
		  //  currentSession.close();

	    }
	    
	  

/*	    public User getUser(String userName, String password)
	    {
	    	//Session session = HibernateUtil.getSessionFactory().openSession();
	    	//session.beginTransaction();
	    	Session currentSession = sessionFactory.getCurrentSession();
		    String stringQuery = "FROM User WHERE userName='" + userName + "' and password= '"+password+"'";
		    Query query = currentSession.createQuery(stringQuery);
		    List<User> usr = query.getResultList();
		   // System.out.println("Let us c" + usr.get(0).getBirthDate());
		   // session.close();
		    //return Response.ok(usr.get(0)).build();
		    return usr.get(0);
	    }*/

		
	}
