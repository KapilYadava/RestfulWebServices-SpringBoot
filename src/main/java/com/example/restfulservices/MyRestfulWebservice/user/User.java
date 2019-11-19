package com.example.restfulservices.MyRestfulWebservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is about user description")
public class User {

	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 or more characters")
	@ApiModelProperty(notes = "Name should have atleast 2 or more characters")
	private String name;
	@JsonIgnore
	@Past(message = "dob must be in past")
	@ApiModelProperty(notes = "dob should be in the past")
	private Date dob;
	
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
	
	
	
}
