package com.himanshu.blogger.dao;

import java.util.List;

import com.himanshu.blogger.model.Role;

public interface RoleDao {
	
	 Role findById(Integer roleId);

	 List<Role> findAll();	
	 
	 Role findByType(String type);
}
