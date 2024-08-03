package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.google.protobuf.Field;
import com.javaweb.builder.BuildingSearchBuider;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	static final String USER = "root";
	static final String PASS = "12345";

	public static void joinTable(BuildingSearchBuider buildingSearchBuider, StringBuilder sql) {
		Integer staffid=buildingSearchBuider.getStaffid();
		if (staffid!=null) {
			sql.append(" INNER JOIN assignmentbuilding on b.id=assignmentbuilding.buildingid ");
		}
		Integer rentAreaTo =  buildingSearchBuider.getAreaTo();
		Integer rentAreaFrom = buildingSearchBuider.getAreaFrom();
		if (rentAreaTo!=null ||rentAreaFrom!=null ) {
			sql.append(" INNER JOIN rentarea on b.id=rentarea.buildingid ");
		}
	}

	public static void queryNomal(BuildingSearchBuider buildingSearchBuider, StringBuilder where) {
		try {
			java.lang.reflect.Field[] fields =BuildingSearchBuider.class.getDeclaredFields();
			for(java.lang.reflect.Field it:fields) {
				it.setAccessible(true);
				String fieldName=it.getName();
				if (!fieldName.equals("staffId") && !fieldName.equals("type") && !fieldName.startsWith("area") && !fieldName.startsWith("rent")) {
					Object value=it.get(buildingSearchBuider);
					if (value!=null) {
						if (it.getType().getName().equals("java.lang.Integer")) {
							where.append(" AND b." + fieldName + " = " + value);
						} else if(it.getType().getName().equals("java.lang.String")){
							where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void querySpecial(BuildingSearchBuider buildingSearchBuider, StringBuilder where) {
		Integer staffid=buildingSearchBuider.getStaffid();
		if (staffid!=null) {
			where.append(" AND assignmentbuilding.staffid = " + staffid);
		}
		Integer rentAreaTo =  buildingSearchBuider.getAreaTo();
		Integer rentAreaFrom = buildingSearchBuider.getAreaFrom();
		if (rentAreaTo!=null ||rentAreaFrom!=null ) {
			if (rentAreaTo!=null) {
				where.append(" AND rentarea.value  >= " + rentAreaFrom);
			}
			if (rentAreaFrom!=null) {
				where.append(" AND rentarea.value  <= " + rentAreaTo);
			}
		}
		Integer rentPriceTo = buildingSearchBuider.getRentpriceTo();
		Integer rentPriceFrom = buildingSearchBuider.getRentpriceFrom();
		if (rentPriceTo!=null||rentPriceFrom!=null) {
			if (rentPriceFrom!=null) {
				where.append(" AND b.rentprice  >= " + rentPriceFrom);
			}
			if (rentPriceTo!=null) {
				where.append(" AND b.rentprice  <= " + rentPriceTo);
			}
		}
		String type=buildingSearchBuider.getType();
		if (type != null && !type.equals("") ) {
			where.append(" AND b.type LIKE '%type%' " );
		}
	}

	@Override
	public ArrayList<BuildingEntity> findAll(BuildingSearchBuider buildingSearchBuider) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b ");
		StringBuilder where = new StringBuilder("WHERE 1=1 ");
		joinTable(buildingSearchBuider, sql);
		queryNomal(buildingSearchBuider, where);
		querySpecial(buildingSearchBuider, where);
		where.append(" group by b.id");
		sql.append(where);
		System.out.print(sql.toString());
		ArrayList<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				java.sql.Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("b.name"));
				buildingEntity.setWard(rs.getString("b.ward"));
				buildingEntity.setDistrict(rs.getString("b.district"));
				buildingEntity.setStreet(rs.getString("b.street"));
				buildingEntity.setFloorarea(rs.getInt("b.floorarea"));
				buildingEntity.setRentprice(rs.getInt("b.rentprice"));
				buildingEntity.setManagername(rs.getString("b.managername"));
				buildingEntity.setManagerphone(rs.getString("b.managerphone"));
				buildingEntity.setNumberofbasement(rs.getInt("b.numberofbasement"));
				result.add(buildingEntity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("faild");
		}
		return result;
	}
}
