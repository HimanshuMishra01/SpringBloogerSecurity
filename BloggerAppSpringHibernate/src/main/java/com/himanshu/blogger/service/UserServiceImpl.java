package com.himanshu.blogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.blogger.dao.UserDao;
import com.himanshu.blogger.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findByUserId(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public List<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {

		return userDao.findAllUsers();

	}
	
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	@Override
	public void updateUser(User user) {
		User entity = userDao.findById(user.getUserId());
		if(entity!=null){
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserRoles(user.getUserRoles());
		}
	}

	@Override
	public boolean isUniqueUserId(String userId) {
		User user = null;
		if (userId != null && !userId.trim().equals("")) {
			user = findByUserId(userId);
		}
		return (user == null);
	}

	@Override
	public void saveUser(User user) {
		System.out.println("save 2");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("save 3 user = "+user);
		userDao.saveUser(user);
		
	}

	@Override
	public void deleteUserByUserId(String userId) {
		userDao.deleteUserByUserId(userId);		
	}

}
