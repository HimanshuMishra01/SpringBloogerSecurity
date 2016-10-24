package com.himanshu.blogger.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.himanshu.blogger.model.Role;
import com.himanshu.blogger.service.RoleService;

@Component
public class RoleIdtoRoleConverter implements Converter<Object, Role> {

	static final Logger logger = LoggerFactory.getLogger(RoleIdtoRoleConverter.class);
    
	@Autowired
	RoleService roleService;

	public Role convert(Object roleIdObj) {

		System.out.println("covertor called with id " + roleIdObj.toString());
		System.out.println("baba 1");
		Integer roleId = -1;
		System.out.println("baba 2");
		try {
			System.out.println("baba 3");
			roleId = Integer.parseInt((String) roleIdObj);
			System.out.println("baba 4 roleId = "+roleId);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(Role.class), roleIdObj, null);
		}

		System.out.println("baba 5");

		Role role = roleService.findRoleById(roleId);
		logger.info("Role = " + role);

		return role;
	}
}
