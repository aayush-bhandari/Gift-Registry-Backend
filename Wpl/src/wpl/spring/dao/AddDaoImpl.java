package wpl.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.SystemPropertyUtils;

import wpl.spring.entity.Filter;
import wpl.spring.entity.Inventory;
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

	
	public List<Inventory> searchItem(Inventory search) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM Inventory WHERE itemName='" + search.getItemName() + "'";
	    Query query = currentSession.createQuery(stringQuery);
	    List<Inventory> items = query.getResultList();
	
	    if (items.size() != 0)
	    {
	    	return items;
	    } else {
	    	return null;
	    }
		
	}

	
	public List<Inventory> filterItem(Filter filter) {
		Session currentSession = sessionFactory.getCurrentSession();
		StringBuilder stringQuery = new StringBuilder();
		stringQuery.append("FROM Inventory WHERE ");
		
		if(!filter.getCategory().isEmpty())
		{
			stringQuery.append("category IN (");
			int count =0, size = filter.getCategory().size();
			while(count<=size-1){
				stringQuery.append( filter.getCategory().get(count)+",") ;
				count++;
			}
			stringQuery.deleteCharAt(stringQuery.length()-1);
			stringQuery.append(")");
		}
		
		if(filter.getPrice()>0)
		{
			System.out.println(filter.getPrice());
			System.out.println("value"+ filter.getPrice());
			if (filter.getCategory().isEmpty())
				stringQuery.append(" price <= "+filter.getPrice());
			else
				stringQuery.append(" AND price <= "+filter.getPrice());
		}
		
		if(filter.getWeight()>0)
		{
			if (filter.getCategory().isEmpty() && filter.getPrice()==0)
				stringQuery.append(" weight <= "+filter.getWeight());
			else
				stringQuery.append(" AND weight <= "+filter.getWeight());
		}
		
		if(!filter.getSize().isEmpty())
		{
			if(filter.getCategory().isEmpty() && filter.getPrice()==0 && filter.getWeight() ==0)
				stringQuery.append(" size IN (");
			else
				stringQuery.append(" AND size IN (");
			
			int count =0, size = filter.getSize().size();
			while(count<=size-1){
				stringQuery.append("'"+filter.getSize().get(count)+"',") ;
				count++;
			}
			stringQuery.deleteCharAt(stringQuery.length()-1);
			stringQuery.append(")");
		}
		 
		System.out.println(stringQuery.toString());
		  Query query = currentSession.createQuery(stringQuery.toString());
		  List<Inventory> items = query.getResultList();
		  
		  if (items.size() != 0)
		    {
		    	return items;
		    } else {
		    	return null;
		    }
			
	}
}
