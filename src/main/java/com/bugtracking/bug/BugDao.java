package com.bugtracking.bug;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.project.Project;
import com.bugtracking.user.User;

@Repository
public interface BugDao extends JpaRepository<Bug, Long> {

	/**
	 * Dao method used to find a bug by id
	 * 
	 * @param bugId String
	 * @return Bug
	 */
	public Bug findByBugId(String id);

	/**
	 * Dao method used to to delete a bug by id
	 * 
	 * @param bugId String
	 * @return Bug
	 */
	public Long deleteByBugId(String bugId);

	/**
	 * Dao method used to get list of bug by project
	 * 
	 * @param bugId String
	 * @return {@code List<Bug>}
	 */
	public List<Bug> findByProject(Project project);

	/**
	 * Dao method used to to get list of bug by user *
	 * 
	 * @param bugId String
	 * @return {@code List<Bug>}
	 */
	public List<Bug> findByUser(User user);

	/**
	 * Dao method used to to get list of bug by user and project*
	 * 
	 * @param bugId String
	 * @return {@code List<Bug>}
	 */
	public List<Bug> findByUserAndProject(User user, Project project);

}
