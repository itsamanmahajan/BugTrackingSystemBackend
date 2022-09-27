package com.bugtracking.project;

import java.util.List;

import com.bugtracking.bug.BugDetailsWrapper;
import com.bugtracking.shared.OperationStatusModel;

public interface IProjectService {
	public ProjectDetailsWrapper getProject(String id);

	public ProjectDetailsWrapper createProject(ProjectDetailsWrapper projectDetailsWrapper);

	public ProjectDetailsWrapper updateProject(String id, ProjectDetailsWrapper projectDetailsWrapper);

	public List<ProjectDetailsWrapper> getAllProjects();

	public OperationStatusModel deleteProject(String id);

	public List<BugDetailsWrapper> getAllBugByProjectId(String id);

}
