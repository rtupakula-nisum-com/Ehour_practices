package com.nisum.timesheets.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "PROJECT_ASSIGNMENT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProjectAssignment implements Serializable {
    private static final long serialVersionUID = -2396783805401137165L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSIGNMENT_ID")
    private Integer assignmentId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    @NotNull
    private Project project;

    @Column(name = "HOURLY_RATE")
    private Float hourlyRate;

    @Column(name = "DATE_START")
    private Date dateStart;

    @Column(name = "DATE_END")
    private Date dateEnd;

    @Column(name = "ROLE", length = 255)
    private String role;

    @ManyToOne
    @JoinColumn(name = "ASSIGNMENT_TYPE_ID")
    @NotNull
    private ProjectAssignmentType assignmentType;

    @Column(name = "ALLOTTED_HOURS")
    private Float allottedHours;

    @Column(name = "ALLOTTED_HOURS_OVERRUN")
    private Float allowedOverrun;

    @Column(name = "NOTIFY_PM_ON_OVERRUN")
    @Type(type = "yes_no")
    private Boolean notifyPm = Boolean.FALSE;

    @Column(name = "ACTIVE", nullable = false)
    @Type(type = "yes_no")
    private Boolean active;

    @Transient
    private boolean deletable;

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ProjectAssignmentType getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(ProjectAssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	public Float getAllottedHours() {
		return allottedHours;
	}

	public void setAllottedHours(Float allottedHours) {
		this.allottedHours = allottedHours;
	}

	public Float getAllowedOverrun() {
		return allowedOverrun;
	}

	public void setAllowedOverrun(Float allowedOverrun) {
		this.allowedOverrun = allowedOverrun;
	}

	public Boolean getNotifyPm() {
		return notifyPm;
	}

	public void setNotifyPm(Boolean notifyPm) {
		this.notifyPm = notifyPm;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

}
