package com.bugtracking.bug;

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

import com.bugtracking.shared.OperationStatusModel;

@ResponseBody
@RequestMapping( "/api/bugs")
public interface IBugRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public BugDetailsWrapper createbug(@RequestBody BugDetailsWrapper projectDetailsWrapper);

	@GetMapping(path = "/{id}")
	public BugDetailsWrapper getbug(@PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public BugDetailsWrapper updatebug(@PathVariable String id, @RequestBody BugDetailsWrapper projectDetailsWrapper);

	@GetMapping()
	public List<BugDetailsWrapper> getAllBug();

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deletebug(@PathVariable String id);

}
