package com.bugtracking.project;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bugtracking.bug.BugDetailsWrapper;
import com.bugtracking.shared.OperationStatusModel;

@ResponseBody
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, path = "/api/projects")
public interface IProjectRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ProjectDetailsWrapper createProject(@RequestBody ProjectDetailsWrapper projectDetailsWrapper);

	@GetMapping(path = "/{id}")
	public ProjectDetailsWrapper getProject(@PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ProjectDetailsWrapper updateProject(@PathVariable String id,
			@RequestBody ProjectDetailsWrapper projectDetailsWrapper);

	@GetMapping()
	public List<ProjectDetailsWrapper> getAllProject();

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteProject(@PathVariable String id);

	@GetMapping(path = "/{id}/bugs")
	public List<BugDetailsWrapper> getAllBugs(@PathVariable String id);

}
