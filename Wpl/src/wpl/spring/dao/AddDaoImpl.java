package wpl.spring.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.registryItem;

@Repository
public class AddDaoImpl implements AddItemDao {

	//Inject session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	public void addItem(registryItem ri) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// add item
		
		currentSession.save(ri);
		
	}

	public void updateItem(registryItem update) {
		
		Session currentSession = sessionFactory.getCurrentSession();
    	System.out.println(update.getRegistrtyId());
	    String stringQuery = "UPDATE registryItem SET Quantity= :quantity WHERE RegistryID= '"+update.getRegistrtyId()+"' AND ItemId = '"+update.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    query.setParameter("quantity", update.getQuantity());
	    query.executeUpdate();
	    
		
	}

	public void removeItem(registryItem remove) {
		Session currentSession = sessionFactory.getCurrentSession();
		 String stringQuery = "DELETE from registryItem WHERE RegistryID= '"+remove.getRegistrtyId()+"' AND ItemId = '"+remove.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    query.executeUpdate();
		
	}
}
