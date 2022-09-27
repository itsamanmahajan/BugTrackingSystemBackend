package com.bugtracking.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bugtracking.bug.Bug;
import com.bugtracking.user.shared.OperationStatusModel;

public interface IUserService  extends UserDetailsService {
	public UserResponseWrapper getUser(String id);

	public UserResponseWrapper createUser(UserDetailsWrapper userDetailsWrapper);

	public UserResponseWrapper updateUser(String id, UserDetailsWrapper userDetailsWrapper);

	public List<UserResponseWrapper> getAllUsers();

	public OperationStatusModel deleteUser(String id);

	public UserResponseWrapper getUserByBugId(Bug existingBug);

	public List<UserResponseWrapper> getAllDevUser();

	public OperationStatusModel activedUser(String id);
	
	public UserResponseWrapper getUserByEmail(String email);


}
