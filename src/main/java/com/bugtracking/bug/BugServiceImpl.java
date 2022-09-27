package com.bugtracking.bug;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.project.Project;
import com.bugtracking.project.ProjectDao;
import com.bugtracking.shared.ErrorMessages;
import com.bugtracking.shared.OperationStatusModel;
import com.bugtracking.shared.RequestOperationName;
import com.bugtracking.shared.RequestOperationStatus;
import com.bugtracking.user.IUserService;
import com.bugtracking.user.User;
import com.bugtracking.user.UserDao;
import com.bugtracking.utils.BugUtils;

@Service("BugServiceImpl")
public class BugServiceImpl implements IBugService {

	@Autowired
	BugDao bugDao;

	@Autowired
	ModelMapper mapper;

	@Autowired
	BugUtils bugUtils;

	@Autowired
	IUserService userService;

	@Autowired
	ProjectDao projectDao;

	@Autowired
	UserDao userDao;

//	public BugServiceImpl(BugDao bugDao, ProjectDao projectDao, UserDao userDao) {
//		this.bugDao = bugDao;
//		this.projectDao = projectDao;
//		this.userDao = userDao;
//	}

	/**
	 * Service Method used to get a bug by bugId
	 * 
	 * @param id String
	 * @return returnValue BugDetailsWrapper
	 * @throws BugServiceException
	 * 
	 **/
	@Override
	public BugDetailsWrapper getbug(String id) throws BugServiceException {
		Bug bug = bugDao.findByBugId(id);
		if (bug == null) {
			throw new BugServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return mapper.map(bug, BugDetailsWrapper.class);

	}

	/**
	 * Service Method used to create a bug
	 * 
	 * @param bugDetailsWrapper BugDetailsWrapper
	 * @return returnValue BugDetailsWrapper
	 */
	@Override
	public BugDetailsWrapper createbug(BugDetailsWrapper bugDetailsWrapper) {
		String publicId = bugUtils.generateBugId(15);
		Project project = projectDao.findProjectByProjectId(bugDetailsWrapper.getProjectId());
		User assignUser = userDao.findUserByUserId(bugDetailsWrapper.getUserId());
		bugDetailsWrapper.setBugId(publicId);
		Bug bug = mapper.map(bugDetailsWrapper, Bug.class);
		bug.setProject(project);
		bug.setUser(assignUser);
		bug.setDeveloper(assignUser.getFirstName() + " " + assignUser.getLastName());
		bug = bugDao.save(bug);
		return mapper.map(bug, BugDetailsWrapper.class);
	}

	/**
	 * Service Method used to update a existing bug
	 * 
	 * @param id String
	 * @param bugDetailsWrapper BugDetailsWrapper
	 * @return returnValue BugDetailsWrapper
	 * @throws BugServiceException
	 * 
	 **/
	@Override
	public BugDetailsWrapper updatebug(String id, BugDetailsWrapper bugDetailsWrapper) throws BugServiceException {
		Bug storeBug = bugDao.findByBugId(id);
		User assignUser = userDao.findUserByUserId(bugDetailsWrapper.getUserId());
		if (storeBug == null) {
			throw new BugServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		storeBug.setDescription(bugDetailsWrapper.getDescription());
		storeBug.setTitle(bugDetailsWrapper.getTitle());
		storeBug.setStatus(bugDetailsWrapper.getStatus());
		storeBug.setDeveloper(assignUser.getFirstName() + " " + assignUser.getLastName());
		Bug returnValue = bugDao.save(storeBug);
		return mapper.map(returnValue, BugDetailsWrapper.class);
	}

	/**
	 * Service Method used to get all bugs
	 * 
	 * @return {@code List<BugDetailsWrapper>}
	 * 
	 **/
	@Override
	public List<BugDetailsWrapper> getAllBug() {
		List<Bug> allBugs = bugDao.findAll();
		return allBugs.stream().map(bug -> mapper.map(bug, BugDetailsWrapper.class)).collect(Collectors.toList());

	}

	/**
	 * Service Method used to delete a existing bug by bugId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	@Transactional
	public OperationStatusModel deletebug(String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationStatus(RequestOperationStatus.ERROR.name());
		bugDao.deleteByBugId(id);
		returnValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	/**
	 * Service Method used to get all existing bug by project
	 * 
	 * @param existingProject Project
	 * @return returnValue List<BugDetailsWrapper>
	 * 
	 **/
	@Override
	public List<BugDetailsWrapper> getAllBugByProject(Project existingProject) {
		List<Bug> bugs = bugDao.findByProject(existingProject);
		if (bugs == null || bugs.isEmpty()) {
			return new ArrayList<>();
		}
		return bugs.stream().map(bugEntity -> mapper.map(bugEntity, BugDetailsWrapper.class))
				.collect(Collectors.toList());
	}

}
