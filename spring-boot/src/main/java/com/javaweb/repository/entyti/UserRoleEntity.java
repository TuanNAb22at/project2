package com.javaweb.repository.entyti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "user_id")
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private UserEntity userEntity;
//	
//	@ManyToOne
//	@JoinColumn(name="role_id")
//	private RoleEntity roleEntity;
//
//	public UserEntity getUserEntity() {
//		return userEntity;
//	}
//
//	public void setUserEntity(UserEntity userEntity) {
//		this.userEntity = userEntity;
//	}
//
//	public RoleEntity getRoleEntity() {
//		return roleEntity;
//	}
//
//	public void setRoleEntity(RoleEntity roleEntity) {
//		this.roleEntity = roleEntity;
//	}
//	
	
}
