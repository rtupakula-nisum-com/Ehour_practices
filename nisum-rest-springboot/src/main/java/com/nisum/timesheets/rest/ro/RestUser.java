package com.nisum.timesheets.rest.ro;

import java.util.HashSet;
import java.util.Set;

import com.nisum.timesheets.rest.domain.User;
import com.nisum.timesheets.rest.domain.UserRole;


public class RestUser {

	private String username;
	private String firstName;
	private String lastName;
	private String approver;
	private String email;
	private boolean active;
	private String functionalGroup;
	private RestEmployeeType employeeType;
	private RestLocation location;
	private Set<RestUserRole> roles;

	public RestUser(User user) {
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.setEmail(user.getEmail());
		this.setActive(user.getActive());
		//this.functionalGroup = user.getLegacyDepartment().getName();
		this.setEmployeeType(new RestEmployeeType(user.getEmployeeType()));
		this.setLocation(new RestLocation(user.getLocation()));

		Set<RestUserRole> userRoles = new HashSet<RestUserRole>();
		for(UserRole uRole : user.getUserRoles()) {
			userRoles.add(new RestUserRole(uRole));			
		}
		this.setRoles(userRoles);
		this.approver = (user.getApprover() != null) ? 
				user.getApprover().getFirstName() : null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getFunctionalGroup() {
		return functionalGroup;
	}
	public void setFunctionalGroup(String functionalGroup) {
		this.functionalGroup = functionalGroup;
	}
	public RestEmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(RestEmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	public RestLocation getLocation() {
		return location;
	}
	public void setLocation(RestLocation location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<RestUserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<RestUserRole> roles) {
		this.roles = roles;
	}
	
}
