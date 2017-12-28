package com.nisum.timesheets.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Project Assignment type
 **/
@Entity
@Table(name = "PROJECT_ASSIGNMENT_TYPE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectAssignmentType implements Serializable {
	private static final long serialVersionUID = -4306635642163206242L;

    @Id
    @Column(name = "ASSIGNMENT_TYPE_ID")
	private	Integer	assignmentTypeId;

    @Column(name = "ASSIGNMENT_TYPE", length = 64)
	private	String	assignmentType;

	public Integer getAssignmentTypeId() {
		return assignmentTypeId;
	}

	public void setAssignmentTypeId(Integer assignmentTypeId) {
		this.assignmentTypeId = assignmentTypeId;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	
}
