package wpl.spring.dao;

import wpl.spring.entity.registryItem;

public interface AddItemDao {

	public void addItem(registryItem ri);

	public void updateItem(registryItem update);

	public void removeItem(registryItem remove);

}
