package com.himanshu.blogger.service;

import java.util.List;

import com.himanshu.blogger.model.User;

public interface UserService {
	
	public User findByUserId(String userId);
	
	public List<User> findByUserName(String userName);	
	
	public List<User> findAll();
	
	public boolean isUniqueUserId(String userId);
	
	public void saveUser(User user);
	
	void deleteUserByUserId(String userId);
	
	void updateUser(User user);

}
