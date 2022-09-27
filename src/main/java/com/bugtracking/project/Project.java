package com.bugtracking.project;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bugtracking.base.model.BaseEntity;
import com.bugtracking.bug.Bug;
import com.bugtracking.user.User;

/**
 * The {@code Project} class represents mapping [Entity class] to database table
 * Project.
 */
@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "projectid_pk")
	private Long id;

	@Column(name = "name")
	private String projectName;

	@Column(name = "projectid")
	private String projectId;

	@Column(name = "decription")
	private String description;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;

	@OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
	private List<Bug> bugs;

	public Project(Long id) {
		this.id = id;
	}

	public Project() {
	}

	public enum ProjectStatus {
		ACTIVE, NOT_ACTIVE, DEPLOYED, CLOSE, INPROGRESS;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getId() {
		return id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

}
