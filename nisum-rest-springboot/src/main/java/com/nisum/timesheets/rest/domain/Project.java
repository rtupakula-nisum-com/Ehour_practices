package com.nisum.timesheets.rest.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "PROJECT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Project implements Serializable {
    private static final long serialVersionUID = 6553709211219335091L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROJECT_ID")
    private Integer projectId;

    @Column(name = "PROJECT_CODE", length = 32, nullable = false)
    @NotNull
    private String projectCode;

    @Column(name = "CONTACT", length = 255)
    private String contact;

    @Column(name = "DESCRIPTION", length = 1024)
    private String description;

    @Column(name = "NAME", length = 255, nullable = false)
    @NotNull
    private String name;

    @Column(name = "DEFAULT_PROJECT")
    @Type(type = "yes_no")
    private Boolean defaultProject = Boolean.FALSE;

    @Column(name = "ACTIVE")
    @Type(type = "yes_no")
    private Boolean active = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = true)
    @NotNull
    private Customer customer;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "project")
    @Basic(fetch = FetchType.LAZY)
    private Set<ProjectAssignment> projectAssignments;

    @ManyToOne
    @JoinColumn(name = "PROJECT_MANAGER", nullable = true)
    private User projectManager;

    @Transient
    private boolean deletable;

    @Column(name = "BILLABLE")
    @Type(type = "yes_no")
    private Boolean billable = Boolean.TRUE;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDefaultProject() {
		return defaultProject;
	}

	public void setDefaultProject(Boolean defaultProject) {
		this.defaultProject = defaultProject;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<ProjectAssignment> getProjectAssignments() {
		return projectAssignments;
	}

	public void setProjectAssignments(Set<ProjectAssignment> projectAssignments) {
		this.projectAssignments = projectAssignments;
	}

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

	public Boolean getBillable() {
		return billable;
	}

	public void setBillable(Boolean billable) {
		this.billable = billable;
	}
    

}
