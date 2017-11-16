package wpl.spring.dao;

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

	@Override
	public void addItem(registryItem ri) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// add item
		
		currentSession.save(ri);
		
	}
}
