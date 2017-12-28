package com.nisum.timesheets.rest.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "USER_DEPARTMENT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserDepartment implements Serializable {
    private static final long serialVersionUID = 7802944013593353L;

    @Transient
    private boolean deletable;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 512)
    private String name;

    @NotNull
    @Column(name = "CODE", nullable = false, length = 64)
    private String code;

    @ManyToOne(optional = true)
    @JoinColumn(name = "MANAGER_USER_ID")
    private User manager;

    @Column(name = "timezone", nullable = true)
    private ZonedDateTime timeZone;

    @ManyToOne(optional = true)
    @JoinColumn(name = "PARENT_DEPARTMENT_ID")
    private UserDepartment parentUserDepartment;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentUserDepartment", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserDepartment> childrenUserDepartments;

    @ManyToMany(mappedBy = "userDepartments")
    private Set<User> users;

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public ZonedDateTime getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(ZonedDateTime timeZone) {
		this.timeZone = timeZone;
	}

	public UserDepartment getParentUserDepartment() {
		return parentUserDepartment;
	}

	public void setParentUserDepartment(UserDepartment parentUserDepartment) {
		this.parentUserDepartment = parentUserDepartment;
	}

	public Set<UserDepartment> getChildrenUserDepartments() {
		return childrenUserDepartments;
	}

	public void setChildrenUserDepartments(Set<UserDepartment> childrenUserDepartments) {
		this.childrenUserDepartments = childrenUserDepartments;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

    
}
