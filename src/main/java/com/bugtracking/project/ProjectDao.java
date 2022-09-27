package com.bugtracking.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {

	/**
	 * Dao method used to find a project by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public Project findProjectByProjectId(String projectId);

	/**
	 * Dao method used to to delete a project by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public Long deleteByProjectId(String projectId);

}
