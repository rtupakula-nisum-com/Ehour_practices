package com.nisum.timesheets.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "EMPLOYEE_TYPE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmployeeType implements Serializable {
	private static final long serialVersionUID = 8721970403797624404L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_TYPE_ID")
	private Integer employeeTypeId;

	@Column(name = "EMPLOYEE_TYPE_NAME", length = 45)
	private String employeeTypeName;

	@Column(name = "EMPLOYEE_TYPE_TYPE")
	@Enumerated(EnumType.STRING)
	private EmployeeTypeType employeeTypeType;

	public Integer getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Integer employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}

	public EmployeeTypeType getEmployeeTypeType() {
		return employeeTypeType;
	}

	public void setEmployeeTypeType(EmployeeTypeType employeeTypeType) {
		this.employeeTypeType = employeeTypeType;
	}

	
}
