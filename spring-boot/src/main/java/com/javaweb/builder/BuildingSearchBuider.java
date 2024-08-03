package com.javaweb.builder;

import org.springframework.context.annotation.Bean;

public class BuildingSearchBuider {
	private String name, managername, managerphone, type;
	private int floorarea, numberofbasement, rentpriceFrom, rentpriceTo, staffid, areaFrom, areaTo;
	private String district;
	private String ward;
	private String street;
	private BuildingSearchBuider(Builder builder) {
		this.name = builder.name;
		this.managername = builder.managername;
		this.managerphone = builder.managerphone;
		this.type = builder.type;
		this.floorarea = builder.floorarea;
		this.numberofbasement = builder.numberofbasement;
		this.rentpriceFrom = builder.rentpriceFrom;
		this.rentpriceTo = builder.rentpriceTo;
		this.staffid = builder.staffid;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.district = builder.district;
		this.ward = builder.ward;
		this.street = builder.street;
	}

	public String getName() {
		return name;
	}

	public String getManagername() {
		return managername;
	}

	public String getManagerphone() {
		return managerphone;
	}

	public String getType() {
		return type;
	}

	public int getFloorarea() {
		return floorarea;
	}

	public int getNumberofbasement() {
		return numberofbasement;
	}

	public int getRentpriceFrom() {
		return rentpriceFrom;
	}

	public int getRentpriceTo() {
		return rentpriceTo;
	}

	public int getStaffid() {
		return staffid;
	}

	public int getAreaFrom() {
		return areaFrom;
	}

	public int getAreaTo() {
		return areaTo;
	}

	public String getDistrict() {
		return district;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public static class Builder {
		private String name, managername, managerphone, type;
		private int floorarea, numberofbasement, rentpriceFrom, rentpriceTo, staffid, areaFrom, areaTo;
		private String district;
		private String ward;
		private String street;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setManagername(String managername) {
			this.managername = managername;
			return this;
		}

		public Builder setManagerphone(String managerphone) {
			this.managerphone = managerphone;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setFloorarea(int floorarea) {
			this.floorarea = floorarea;
			return this;
		}

		public Builder setNumberofbasement(int numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this;
		}

		public Builder setRentpriceFrom(int rentpriceFrom) {
			this.rentpriceFrom = rentpriceFrom;
			return this;
		}

		public Builder setRentpriceTo(int rentpriceTo) {
			this.rentpriceTo = rentpriceTo;
			return this;
		}

		public Builder setStaffid(int staffid) {
			this.staffid = staffid;
			return this;
		}

		public Builder setAreaFrom(int areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Builder setAreaTo(int areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public BuildingSearchBuider buid() {
			return new BuildingSearchBuider(this);
		}
	}
}
