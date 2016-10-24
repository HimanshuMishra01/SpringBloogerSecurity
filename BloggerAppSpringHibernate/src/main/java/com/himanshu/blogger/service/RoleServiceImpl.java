package com.himanshu.blogger.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.blogger.dao.RoleDao;
import com.himanshu.blogger.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public Role findRoleById(Integer roleId) {
		System.out.println("baba 6");
		return roleDao.findById(roleId);
	}

	@Override
	public List<Role> findAll() {		
		return roleDao.findAll();
	}

	@Override
	public Role findByType(String roleType) {
		return roleDao.findByType(roleType);
	}

}
