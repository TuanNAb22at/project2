package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
@Primary
public class BuildingRepositoryimpl implements BuildingRepository {
	@PersistenceContext
	private EntityManager entityManager;
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
			if (rentAreaFrom != null) {
				where.append(" AND rentarea.value  >= " + rentAreaFrom);
			}
			if (rentAreaTo != null) {
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
		System.out.println(sql.toString());
		Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
		return (ArrayList<BuildingEntity>) query.getResultList();
	}
}
