package com.himanshu.blogger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.himanshu.blogger.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao{

	@Override
	public Role findById(Integer roleId) {
		System.out.println("baba 7");
		return getByKey(roleId);
	}

	@Override
	public Role findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Role) crit.uniqueResult();
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		Criteria criteria=createEntityCriteria().addOrder(Order.asc("roleId"));
		List<Role> roleList=criteria.list();
		
		return roleList;
	}
	
	

}
