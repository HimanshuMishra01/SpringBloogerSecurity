package com.himanshu.blogger.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.himanshu.blogger.model.Role;
import com.himanshu.blogger.model.User;
import com.himanshu.blogger.service.UserService;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		User user = userService.findByUserId(userId);

		logger.info("User : {}", user);

		if (user == null) {
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}

		org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(
																	user.getUserId(), user.getPassword(), (user.getState() == 1),
																	true, true, true, getGrantedAuthorities(user));

		return springUser;
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role userRole : user.getUserRoles()) {
			System.out.println("UserProfile : " + userRole);
			authorities.add(new SimpleGrantedAuthority("ROLE_"
					+ userRole.getRoleType()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}

}
