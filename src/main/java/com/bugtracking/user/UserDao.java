package com.bugtracking.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracking.bug.Bug;
import com.bugtracking.project.Project;
import com.bugtracking.user.User.UserRole;

public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * Dao method used to find a user by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public User findUserByUserId(String userId);
	
	/**
	 * Dao method used to delete a user by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public Long deleteByUserId(String userId);
	
	/**
	 * Dao method used to find a user by bug
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public User findByBugs(Bug bugs);

	/**
	 * Dao method used to delete a users by role
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public List<User> findByRole(UserRole role);

	/**
	 * Dao method used to delete a user by email
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public User findUserByEmail(String email);

}
