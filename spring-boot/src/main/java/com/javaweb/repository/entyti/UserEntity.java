package com.javaweb.repository.entyti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	@Column(name = "fullname")
	private String fullName;

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_role",
		joinColumns=@JoinColumn(name="user_id",nullable=false),
		inverseJoinColumns=@JoinColumn(name="role_id",nullable=false))
	private List<RoleEntity> roles = new ArrayList<>();
	
	
}
