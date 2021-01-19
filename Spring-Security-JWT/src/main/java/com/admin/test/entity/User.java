package com.admin.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String userName;
	private String password;
	private Integer age;

	@OneToMany(targetEntity = Article.class, cascade=CascadeType.ALL)
	@JoinColumn(name="u_id",  referencedColumnName = "id")
	private List<Article> list = new ArrayList<>();

	public User( String userName, String password, Integer age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
	}
	

	public User() {
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public List<Article> getList() {
		return list;
	}
}
