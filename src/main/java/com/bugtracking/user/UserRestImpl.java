package com.bugtracking.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.user.shared.OperationStatusModel;

@RestController
public class UserRestImpl implements IUserRest {

	@Autowired
	IUserService userServiceImpl;

	Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * Controller Method used to get all users
	 * 
	 * @return {@code List<UserResponseWrapper>}
	 * 
	 **/
	@Override
	public List<UserResponseWrapper> getAllUser() {

		return userServiceImpl.getAllUsers();
	}

	/**
	 * Controller Method used create user
	 * 
	 * @return {@code UserResponseWrapper}
	 * 
	 **/
	@Override
	public UserResponseWrapper createUser(UserDetailsWrapper userDetailsWrapper) {
		logger.info("In UserRestImpl createUser Parameter id {}", userDetailsWrapper.getEmail());
		return userServiceImpl.createUser(userDetailsWrapper);
	}

	/**
	 * Controller Method used find user by id
	 * 
	 * @return {@code UserResponseWrapper}
	 * 
	 **/
	@Override
	public UserResponseWrapper getUser(String id) {
		logger.info("In UserRestImpl getProject Parameter id {}", id);
		return userServiceImpl.getUser(id);
	}

	/**
	 * Controller Method used to update a existing user
	 * 
	 * @param id                 String
	 * @param userDetailsWrapper UserDetailsWrapper
	 * @return returnValue UserResponseWrapper
	 * 
	 **/
	@Override
	public UserResponseWrapper updateUser(String id, UserDetailsWrapper userDetailsWrapper) {
		logger.info("In UserRestImpl updateUser Parameter id {}", id);
		return userServiceImpl.updateUser(id, userDetailsWrapper);
	}

	/**
	 * Controller Method used to delete a existing user by usertId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	public OperationStatusModel deleteUser(String id) {
		logger.info("In UserRestImpl deleteUser Parameter id {}", id);
		return userServiceImpl.deleteUser(id);
	}

	/**
	 * Controller Method used to get all developer user
	 * 
	 * @return returnValue List<UserResponseWrapper>
	 * 
	 **/
	@Override
	public List<UserResponseWrapper> getAllDeveloper() {
		return userServiceImpl.getAllDevUser();
	}

	/**
	 * Controller Method used to set active status of existing user by usertId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	public OperationStatusModel activateUser(String id) {
		return userServiceImpl.activedUser(id);
	}

}
