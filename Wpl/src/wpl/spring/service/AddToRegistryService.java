package wpl.spring.service;

import java.util.List;

import wpl.spring.entity.Filter;
import wpl.spring.entity.Inventory;
import wpl.spring.entity.registryItem;

public interface AddToRegistryService {

	public void addItem(registryItem ri) ;
	public void updateItem(registryItem update);
	public void removeItem(registryItem remove);
	public List<Inventory> searchItem(Inventory search);
	public List<Inventory> filterItem(Filter filter);
		

}
