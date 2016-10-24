package com.himanshu.blogger.dao;

import java.util.List;

import com.himanshu.blogger.model.User;

public interface UserDao {
	
	User findById(String userId);
	
	List<User> findAllUsers();
	
	void saveUser(User user);
	
	void deleteUserByUserId(String userId);
}
