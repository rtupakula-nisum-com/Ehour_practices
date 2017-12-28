package com.nisum.timesheets.rest.ro;

import com.nisum.timesheets.rest.domain.EmployeeType;
import com.nisum.timesheets.rest.domain.EmployeeTypeType;

public class RestEmployeeType {
	private String name;
	private EmployeeTypeType type;

	public RestEmployeeType(EmployeeType type) {
		super();
		this.name = type.getEmployeeTypeName();
		this.type = type.getEmployeeTypeType();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type.toString();
	}
	public void setType(EmployeeTypeType type) {
		this.type = type;
	}
}