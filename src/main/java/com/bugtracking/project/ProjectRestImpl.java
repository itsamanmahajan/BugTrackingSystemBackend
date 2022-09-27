package com.bugtracking.project;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.bug.BugDetailsWrapper;
import com.bugtracking.shared.OperationStatusModel;

//@EncryptBody
@RestController
public class ProjectRestImpl implements IProjectRest {

	@Autowired
	IProjectService projectServiceImpl;

	Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * Controller Method used to get all projects
	 * 
	 * @return {@code List<ProjectDetailsWrapper>}
	 * 
	 **/
	@Override
	public List<ProjectDetailsWrapper> getAllProject() {
		return projectServiceImpl.getAllProjects();
	}

	/**
	 * Controller Method used to create a project
	 * 
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 * 
	 **/
	@Override
	public ProjectDetailsWrapper createProject(ProjectDetailsWrapper projectDetailsWrapper) {
		logger.info("In ProjectRestImpl createProject Parameter id {}", projectDetailsWrapper.getProjectName());
		return projectServiceImpl.createProject(projectDetailsWrapper);
	}

	/**
	 * Controller Method used to get a project by projectId
	 * 
	 * @param id String
	 * @return returnValue ProjectDetailsWrapper
	 * 
	 **/
	@Override
	public ProjectDetailsWrapper getProject(String id) {
		logger.info("In ProjectRestImpl getProject Parameter id {}", id);
		return projectServiceImpl.getProject(id);
	}

	/**
	 * Controller Method used to update a existing project
	 * 
	 * @param id String
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 * 
	 **/
	@Override
	public ProjectDetailsWrapper updateProject(String id, ProjectDetailsWrapper projectDetailsWrapper) {
		logger.info("In ProjectRestImpl updateProject Parameter id {}", id);
		return projectServiceImpl.updateProject(id, projectDetailsWrapper);
	}

	/**
	 * Controller Method used to delete a existing project by projectId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	public OperationStatusModel deleteProject(String id) {
		logger.info("In ProjectRestImpl deleteProject Parameter id {}", id);
		return projectServiceImpl.deleteProject(id);
	}

	/**
	 * Controller Method used to get all existing bugs by projectId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	public List<BugDetailsWrapper> getAllBugs(String id) {
		return projectServiceImpl.getAllBugByProjectId(id);
	}

}
