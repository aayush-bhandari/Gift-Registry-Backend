package wpl.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wpl.spring.dao.AddItemDao;
import wpl.spring.entity.Inventory;
import wpl.spring.entity.registryItem;

@Service
public class AddToRegistryServiceImp implements AddToRegistryService {

	//inject additemdao 
	
	@Autowired
	private AddItemDao addItemDao;

	@Override
	@Transactional
	public void addItem(registryItem ri) {
		addItemDao.addItem(ri);
		
	}

	@Override
	@Transactional
	public void updateItem(registryItem update) {
		addItemDao.updateItem(update);
		
	}

	@Override
	@Transactional
	public void removeItem(registryItem remove) {
		addItemDao.removeItem(remove);
		
	}

	@Override
	@Transactional
	public List<Inventory> searchItem(Inventory search) {
		return addItemDao.searchItem(search);
		
	}
	
}
