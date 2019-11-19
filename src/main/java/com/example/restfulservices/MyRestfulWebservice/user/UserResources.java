package com.example.restfulservices.MyRestfulWebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResources {
	
	@Autowired
	UserDaoService service;
	
	@GetMapping(path = "/users")
	public List<User> findAll() {
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public Resource<User> findUser(@PathVariable int id) {
		User user = service.findUser(id);
		if(user == null)
			throw new UserNotFoundException("id =" + id);
		
		//"all-users", SERVER_PATH + "/users"
				//retrieveAllUsers
				Resource<User> resource = new Resource<User>(user);
				
				ControllerLinkBuilder linkTo = 
						linkTo(methodOn(this.getClass()).findAll());
				
				resource.add(linkTo.withRel("all-users"));
				
				linkTo = linkTo(methodOn(this.getClass()).deleteUser(id));
				
				resource.add(linkTo.withRel("delete-user"));
				//HATEOAS
				
		
		return resource;
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User deletedUser = service.deleteUser(id);
		if (deletedUser == null)
			throw new UserNotFoundException("id = " +id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser =service.save(user);
		
		URI location = ServletUriComponentsBuilder.
			fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}

}
