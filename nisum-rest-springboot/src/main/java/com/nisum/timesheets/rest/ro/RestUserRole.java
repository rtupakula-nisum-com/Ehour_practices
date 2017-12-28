package com.nisum.timesheets.rest.ro;

import com.nisum.timesheets.rest.domain.UserRole;

public class RestUserRole {
	private String role;
	private String roleName;
	private String authority;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public RestUserRole(UserRole o) {
		super();
		this.role = o.getRole();
		this.roleName = o.getRoleName();
		//this.authority = o.getAuthority();
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
