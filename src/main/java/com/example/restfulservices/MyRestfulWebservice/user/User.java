package com.example.restfulservices.MyRestfulWebservice.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is about user description")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 or more characters")
	@ApiModelProperty(notes = "Name should have atleast 2 or more characters")
	private String name;
	
	@Past(message = "dob must be in past")
	@ApiModelProperty(notes = "dob should be in the past")
	private Date dob;
	
	@OneToMany(mappedBy="user")
	private List<Post> post;
	
	public User() {
		
	}
	
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
}
