package com.himanshu.blogger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.himanshu.blogger.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, User> implements  UserDao{

	@Override
	public User findById(String userId) {
		User user= getByKey(userId);
		if (user!=null){
			Hibernate.initialize(user.getUserRoles());
		}
		
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria=createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<User> userList = (List<User>) criteria.list();
		for(User user : userList){
            Hibernate.initialize(user.getUserRoles());
        }
		return userList;
	}

	@Override
	public void saveUser(User user) {
		System.out.println("save 4");
		persistEntity(user);
		
	}

	@Override
	public void deleteUserByUserId(String userId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("userId", userId));
		User user = (User)crit.uniqueResult();
		deleteEntity(user);
		
	}

	

}
