package com.javaweb.repository.entyti;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.*;
@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "street")
	private String street;
	@Column(name = "ward")
	private String ward;
	@Column(name = "district")
	private String district;
	@Column(name = "numberofbasement")
	private Integer numberofbasement;
	@Column(name = "floorarea")
	private Integer floorarea;
	@Column(name = "staffid")
	private Integer staffid;
	@Column(name = "rentprice")
	private Integer rentprice;
	@Column(name = "managername")
	private String managername;
	@Column(name = "managerphone")
	private String managerphone;
	@Column(name = "type")
	private String type;
	public String getName() {
		return name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphone() {
		return managerphone;
	}
	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@OneToMany(mappedBy="building",fetch=FetchType.LAZY)
//	private ArrayList<RentareaEntity> items = new ArrayList<>();
//	
//	public ArrayList<RentareaEntity> getItems() {
//		return items;
//	}
//	public void setItems(ArrayList<RentareaEntity> items) {
//		this.items = items;
//	}
}
