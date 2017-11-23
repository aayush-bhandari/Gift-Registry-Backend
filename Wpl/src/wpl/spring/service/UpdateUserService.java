package wpl.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wpl.spring.dao.AddItemDao;
import wpl.spring.dao.UserDao;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;

@Service
public class UpdateUserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
}
