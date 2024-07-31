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
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	static final String USER = "root";
	static final String PASS = "12345";

	public static void joinTable(Map<String, Object> params, ArrayList<String> type, StringBuilder sql) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			sql.append(" INNER JOIN assignmentbuilding on b.id=assignmentbuilding.buildingid ");
		}
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (StringUtil.checkString(rentAreaTo) == true || StringUtil.checkString(rentAreaFrom) == true) {
			sql.append(" INNER JOIN rentarea on b.id=rentarea.buildingid ");
		}
	}

	public static void queryNomal(Map<String, Object> params, ArrayList<String> type, StringBuilder where) {
		for (Map.Entry<String, Object> it : params.entrySet()) {
			if (!it.getKey().equals("staffId") && !it.getKey().equals("type") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rent")) {
				String value = it.getValue().toString();
				if (StringUtil.checkString(value)) {
					if (NumberUtil.isNumber(value)) {
						where.append(" AND b." + it.getKey() + " = " + value);
					} else {
						where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%' ");
					}
				}
			}
		}
	}

	public static void querySpecial(Map<String, Object> params, ArrayList<String> type, StringBuilder where) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			where.append(" AND assignmentbuilding.staffid = " + staffId);
		}
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (StringUtil.checkString(rentAreaTo) == true || StringUtil.checkString(rentAreaFrom) == true) {
			if (StringUtil.checkString(rentAreaFrom)) {
				where.append(" AND rentarea.value  >= " + rentAreaFrom);
			}
			if (StringUtil.checkString(rentAreaTo)) {
				where.append(" AND rentarea.value  <= " + rentAreaTo);
			}
		}
		String rentPriceTo = (String) params.get("rentPriceTo");
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		if (StringUtil.checkString(rentPriceTo) == true || StringUtil.checkString(rentPriceFrom) == true) {
			if (StringUtil.checkString(rentPriceFrom)) {
				where.append(" AND b.rentprice  >= " + rentPriceFrom);
			}
			if (StringUtil.checkString(rentPriceTo)) {
				where.append(" AND b.rentprice  <= " + rentPriceTo);
			}
		}

		if (type != null && type.size() != 0) {
			ArrayList<String> code = new ArrayList<>();
			for (String item : type) {
				code.add("'" + item + "'");
			}
			where.append(" AND b.type IN(" + String.join(",", code) + ") ");

		}
	}

	@Override
	public ArrayList<BuildingEntity> findAll(Map<String, Object> params, ArrayList<String> type) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b ");
		StringBuilder where = new StringBuilder("WHERE 1=1 ");
		joinTable(params, type, sql);
		queryNomal(params, type, where);
		querySpecial(params, type, where);
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
