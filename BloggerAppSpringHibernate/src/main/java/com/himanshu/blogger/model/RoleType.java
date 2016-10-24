package com.himanshu.blogger.model;

public enum RoleType {

	USER("USER"), ADMIN("ADMIN"), MODERATOR("MODERATOR");

	String roleType;

	private RoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleType() {
		return roleType;
	}

}
