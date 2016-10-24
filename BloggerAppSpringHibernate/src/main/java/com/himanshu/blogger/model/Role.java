package com.himanshu.blogger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BLOG_ROLE")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4140575081040268202L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROLE_ID")
	private Integer roleId;
	
	@Column(name="ROLE_TYPE", length=20, nullable=false, unique=true)
	private String roleType=RoleType.USER.getRoleType();
	
	@Column(name="STATE")
	private int state;

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((roleType == null) ? 0 : roleType.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Role))
            return false;
        Role other = (Role) obj;
        if (roleId == null) {
            if (other.roleId != null)
                return false;
        } else if (!roleId.equals(other.roleId))
            return false;
        if (roleType == null) {
            if (other.roleType != null)
                return false;
        } else if (!roleType.equals(other.roleType))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Role [id=" + roleId + ", type=" + roleType + "]";
    }
	

}
