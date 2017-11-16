package wpl.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wpl.spring.dao.AddItemDao;
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
	
}
