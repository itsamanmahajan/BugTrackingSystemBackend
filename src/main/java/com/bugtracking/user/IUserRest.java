package com.bugtracking.user;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugtracking.user.shared.OperationStatusModel;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4201", "" })
@ResponseBody
@RequestMapping("/api/users")

public interface IUserRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public UserResponseWrapper createUser(@RequestBody UserDetailsWrapper userDetailsWrapper);

	@GetMapping(path = "/{id}")
	public UserResponseWrapper getUser(@PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public UserResponseWrapper updateUser(@PathVariable String id,@RequestBody UserDetailsWrapper userDetailsWrapper);

	@GetMapping("")
	public List<UserResponseWrapper> getAllUser();

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id);

	@GetMapping("/dev")
	public List<UserResponseWrapper> getAllDeveloper();

	@PutMapping("/{id}/active")
	public OperationStatusModel activateUser(@PathVariable String id);

}
