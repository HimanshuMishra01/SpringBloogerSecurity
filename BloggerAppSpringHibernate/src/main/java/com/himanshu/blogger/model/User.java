package com.himanshu.blogger.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "BLOG_USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4806187107778099571L;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@NotNull
	@Column(name = "STATE")
	private Integer state = State.ACTIVE.getState();

	@Transient
	private String stateName;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ROLE_MAP", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> userRoles = new HashSet<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Access(AccessType.PROPERTY)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		setStateName(state);
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(int state) {
		if (State.ACTIVE.getState() == state) {
			stateName = State.ACTIVE.getName();
		} else if (State.INACTIVE.getState() == state) {
			stateName = State.INACTIVE.getName();
		} else if (State.LOCKED.getState() == state) {
			stateName = State.LOCKED.getName();
		} else if (State.DELETED.getState() == state) {
			stateName = State.DELETED.getName();
		}
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", state=" + state
				+ ", blogRoles=" + userRoles + "]";
	}

}
