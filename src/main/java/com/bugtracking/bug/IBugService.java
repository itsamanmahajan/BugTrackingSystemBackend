package com.bugtracking.bug;

import java.util.List;

import com.bugtracking.project.Project;
import com.bugtracking.shared.OperationStatusModel;

public interface IBugService {
	public BugDetailsWrapper getbug(String id);

	public BugDetailsWrapper createbug(BugDetailsWrapper projectDetailsWrapper);

	public BugDetailsWrapper updatebug(String id, BugDetailsWrapper projectDetailsWrapper);

	public List<BugDetailsWrapper> getAllBug();

	public OperationStatusModel deletebug(String id);

	public List<BugDetailsWrapper> getAllBugByProject(Project existingProject);

}
