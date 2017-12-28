package com.nisum.timesheets.rest.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "USER_ID")
	    private Integer userId;

	    @NotNull
	    @Column(name = "USERNAME", length = 64)
	    private String username;

	    @NotNull
	    @Column(name = "PASSWORD", nullable = false, length = 128)
	    private String password;

	    @Column(name = "FIRST_NAME", length = 64)
	    private String firstName;

	    @Column(name = "LAST_NAME", nullable = false, length = 64)
	    private String lastName;

	    @Column(name = "EMAIL", length = 128)
	    private String email;

	    @Column(name = "ACTIVE")
	    @Type(type = "yes_no")
	    private Boolean active = Boolean.TRUE;

	    @Column(name = "SALT")
	    private Integer salt;

	    @OneToOne
	    @JoinColumn(name = "APPROVER", referencedColumnName="user_id", nullable = true)
	    @NotNull
	    private User approver;

	    @Transient
	    private String updatedPassword;

	    @ManyToMany(targetEntity = UserRole.class,
	            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
	    )
	    @JoinTable(name = "USER_TO_USERROLE",
	            joinColumns = @JoinColumn(name = "USER_ID"),
	            inverseJoinColumns = @JoinColumn(name = "ROLE"))
	    private Set<UserRole> userRoles = new HashSet<>();

	    @ManyToMany(targetEntity = UserDepartment.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	    @JoinTable(name = "USER_TO_DEPARTMENT",
	            joinColumns = @JoinColumn(name = "USER_ID"),
	            inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID"))

	    private Set<UserDepartment> userDepartments = new HashSet<>();


	    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "user")
	    private Set<ProjectAssignment> projectAssignments;

	    @ManyToOne
	    @JoinColumn(name = "DEPARTMENT_ID")
	    private UserDepartment legacyDepartment;

	    @Transient
	    private Set<ProjectAssignment> inactiveProjectAssignments;

	    @Transient
	    private boolean deletable;

	    @ManyToOne
	    @JoinColumn(name = "COUNTRY_ID", nullable = true)
	    @NotNull
	    private Country country;

	    @OneToOne
	    @JoinColumn(name = "WORKLOCATION", referencedColumnName="LOCATION_ID", nullable = true)
	    @NotNull
	    private Location location;

	    @OneToOne
	    @JoinColumn(name = "EMPLOYEE_TYPE", referencedColumnName="EMPLOYEE_TYPE_ID", nullable = true)
	    @NotNull
	    private EmployeeType employeeType;

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public Integer getSalt() {
			return salt;
		}

		public void setSalt(Integer salt) {
			this.salt = salt;
		}

		public User getApprover() {
			return approver;
		}

		public void setApprover(User approver) {
			this.approver = approver;
		}

		public String getUpdatedPassword() {
			return updatedPassword;
		}

		public void setUpdatedPassword(String updatedPassword) {
			this.updatedPassword = updatedPassword;
		}

		public Set<UserRole> getUserRoles() {
			return userRoles;
		}

		public void setUserRoles(Set<UserRole> userRoles) {
			this.userRoles = userRoles;
		}

		public Set<UserDepartment> getUserDepartments() {
			return userDepartments;
		}

		public void setUserDepartments(Set<UserDepartment> userDepartments) {
			this.userDepartments = userDepartments;
		}

		public Set<ProjectAssignment> getProjectAssignments() {
			return projectAssignments;
		}

		public void setProjectAssignments(Set<ProjectAssignment> projectAssignments) {
			this.projectAssignments = projectAssignments;
		}

		public UserDepartment getLegacyDepartment() {
			return legacyDepartment;
		}

		public void setLegacyDepartment(UserDepartment legacyDepartment) {
			this.legacyDepartment = legacyDepartment;
		}

		public Set<ProjectAssignment> getInactiveProjectAssignments() {
			return inactiveProjectAssignments;
		}

		public void setInactiveProjectAssignments(Set<ProjectAssignment> inactiveProjectAssignments) {
			this.inactiveProjectAssignments = inactiveProjectAssignments;
		}

		public boolean isDeletable() {
			return deletable;
		}

		public void setDeletable(boolean deletable) {
			this.deletable = deletable;
		}

		public Country getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country = country;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public EmployeeType getEmployeeType() {
			return employeeType;
		}

		public void setEmployeeType(EmployeeType employeeType) {
			this.employeeType = employeeType;
		}


}
