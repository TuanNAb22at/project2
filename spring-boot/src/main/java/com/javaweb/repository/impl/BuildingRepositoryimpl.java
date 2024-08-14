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

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	static final String USER = "root";
	static final String PASS = "12345";

	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Integer staffid = buildingSearchBuilder.getStaffId();
		if (staffid != null) {
			sql.append(" INNER JOIN assignmentbuilding on b.id=assignmentbuilding.buildingid ");
		}
		Integer rentAreaTo = buildingSearchBuilder.getAreaTo();
		Integer rentAreaFrom = buildingSearchBuilder.getAreaFrom();
		if (rentAreaTo != null || rentAreaFrom != null) {
			sql.append(" INNER JOIN rentarea on b.id=rentarea.buildingid ");
		}
	}

	public static void queryNomal(BuildingSearchBuilder buildingSearchBuider, StringBuilder where) {
		try {
			java.lang.reflect.Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (java.lang.reflect.Field it : fields) {
				it.setAccessible(true);
				String fieldName = it.getName();
				if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area")
						&& !fieldName.startsWith("rentPrice")) {
					Object value = it.get(buildingSearchBuider);
					if (value != null) {
						if (it.getType().getName().equals("java.lang.Integer")) {
							where.append(" AND b." + fieldName + " = " + value);
						} else if (it.getType().getName().equals("java.lang.String")) {
							where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void querySpecial(BuildingSearchBuilder buildingSearchBuider, StringBuilder where) {
		Integer staffid = buildingSearchBuider.getStaffId();
		if (staffid != null) {
			where.append(" AND assignmentbuilding.staffid = " + staffid);
		}
		Integer rentAreaTo = buildingSearchBuider.getAreaTo();
		Integer rentAreaFrom = buildingSearchBuider.getAreaFrom();
		if (rentAreaTo != null || rentAreaFrom != null) {
			if (rentAreaTo != null) {
				where.append(" AND rentarea.value  >= " + rentAreaFrom);
			}
			if (rentAreaFrom != null) {
				where.append(" AND rentarea.value  <= " + rentAreaTo);
			}
		}
		Integer rentPriceTo = buildingSearchBuider.getRentPriceTo();
		Integer rentPriceFrom = buildingSearchBuider.getRentPriceFrom();
		if (rentPriceTo != null || rentPriceFrom != null) {
			if (rentPriceFrom != null) {
				where.append(" AND b.rentprice  >= " + rentPriceFrom);
			}
			if (rentPriceTo != null) {
				where.append(" AND b.rentprice  <= " + rentPriceTo);
			}
		}
		ArrayList<String> type = (ArrayList<String>) buildingSearchBuider.getTypeCode();
		if (type != null && type.size() != 0) {
			ArrayList<String> code = new ArrayList<>();
			for (String item : type) {
				code.add("'" + item + "'");
			}
			where.append(" AND b.type IN(" + String.join(",", code) + ") ");

		}
	}

	@Override
	public ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b ");
		StringBuilder where = new StringBuilder("WHERE 1=1 ");
		joinTable(buildingSearchBuilder, sql);
		queryNomal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);
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
