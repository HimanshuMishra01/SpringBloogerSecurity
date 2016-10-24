package com.himanshu.blogger.service;

import java.util.List;

import com.himanshu.blogger.model.Role;

public interface RoleService {

	Role findRoleById(Integer roleId);
	
	List<Role> findAll();
	
	Role findByType(String roleType);
}
