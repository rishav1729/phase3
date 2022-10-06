package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the admin")
public class Admin {
	@ApiModelProperty(notes = "The unique id of the admin")
	int id;
	@ApiModelProperty(notes = "Name of the admin")
	String name;
	@ApiModelProperty(notes = "Password of the admin")
	String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
