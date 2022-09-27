package com.bugtracking.project;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.bug.BugDetailsWrapper;
import com.bugtracking.bug.IBugService;
import com.bugtracking.shared.ErrorMessages;
import com.bugtracking.shared.OperationStatusModel;
import com.bugtracking.shared.RequestOperationName;
import com.bugtracking.shared.RequestOperationStatus;
import com.bugtracking.user.User;
import com.bugtracking.user.UserDao;
import com.bugtracking.utils.BugUtils;

@Service("ProjectServiceImpl")
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectDao projectDao;

	@Autowired
	ModelMapper mapper;

	@Autowired
	BugUtils projectUtils;

	@Autowired
	IBugService bugService;

	@Autowired
	UserDao userDao;

	/**
	 * Service Method used to get a project by projectId
	 * 
	 * @param id String
	 * @return returnValue ProjectDetailsWrapper
	 * @throws ProjectServiceException
	 * 
	 **/
	@Override
	public ProjectDetailsWrapper getProject(String id) throws ProjectServiceException {
		Project project = projectDao.findProjectByProjectId(id);
		if (project == null) {
			throw new ProjectServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return mapper.map(project, ProjectDetailsWrapper.class);

	}

	/**
	 * Service Method used to create a project
	 * 
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 */
	@Override
	public ProjectDetailsWrapper createProject(ProjectDetailsWrapper projectDetailsWrapper) {

		String publicId = projectUtils.generateProjectId(15);
		projectDetailsWrapper.setProjectId(publicId);
		Project project = mapper.map(projectDetailsWrapper, Project.class);
		project = projectDao.save(project);
		return mapper.map(project, ProjectDetailsWrapper.class);
	}

	/**
	 * Service Method used to update a existing project
	 * 
	 * @param id                    String
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 * @throws ProjectServiceException
	 * 
	 **/
	@Override
	public ProjectDetailsWrapper updateProject(String id, ProjectDetailsWrapper projectDetailsWrapper)
			throws ProjectServiceException {
		Project storeProject = projectDao.findProjectByProjectId(id);
		if (storeProject == null) {
			throw new ProjectServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		storeProject.setDescription(projectDetailsWrapper.getDescription());
		storeProject.setProjectName(projectDetailsWrapper.getProjectName());
		storeProject.setType(projectDetailsWrapper.getType());
		storeProject.setStatus(projectDetailsWrapper.getStatus());
		Project returnValue = projectDao.save(storeProject);
		return mapper.map(returnValue, ProjectDetailsWrapper.class);
	}

	/**
	 * Service Method used to get all projects
	 * 
	 * @return {@code List<ProjectDetailsWrapper>}
	 * 
	 **/
	@Override
	public List<ProjectDetailsWrapper> getAllProjects() {
		List<Project> allProject = projectDao.findAll();
		return allProject.stream().map(project -> mapper.map(project, ProjectDetailsWrapper.class))
				.collect(Collectors.toList());

	}

	/**
	 * Service Method used to delete a existing project by projectId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	@Transactional
	public OperationStatusModel deleteProject(String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationStatus(RequestOperationStatus.ERROR.name());
		projectDao.deleteByProjectId(id);
		returnValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	/**
	 * Service Method used to get all existing bugs by projectId
	 * 
	 * @param id String
	 * @return {@code List<Bug>}
	 * 
	 **/
	@Override
	public List<BugDetailsWrapper> getAllBugByProjectId(String id) {
		Project existingProject = projectDao.findProjectByProjectId(id);
		return bugService.getAllBugByProject(existingProject);
	}

}
