package com.javaweb.model;

public class BuildingDTO {
	private String tenSanpham,diaChi,tenQuanLy,soDienThoai,name;
	private int soTangHam,giaThue,dtSan,numberofbasement;
	private float phiMG;
	public String getTenSanpham() {
		return tenSanpham;
	}
	public int getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(int numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenQuanLy() {
		return tenQuanLy;
	}
	public void setTenQuanLy(String tenQuanLy) {
		this.tenQuanLy = tenQuanLy;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	public int getDtSan() {
		return dtSan;
	}
	public void setDtSan(int dtSan) {
		this.dtSan = dtSan;
	}
	public int getSoTangHam() {
		return soTangHam;
	}
	public void setSoTangHam(int soTangHam) {
		this.soTangHam = soTangHam;
	}
	public int getGiaThue() {
		return giaThue;
	}
	public void setGiaThue(int giaThue) {
		this.giaThue = giaThue;
	}
	public float getPhiMG() {
		return phiMG;
	}
	public void setPhiMG(float phiMG) {
		this.phiMG = phiMG;
	}
	
	
	
}
