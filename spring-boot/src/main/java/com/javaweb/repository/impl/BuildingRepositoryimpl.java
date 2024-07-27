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
import com.javaweb.utils.NumberUntil;
import com.javaweb.utils.StringUtil;
@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	 static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	 static final String USER = "root";
	 static final String PASS = "12345";
	 public static void joinTable(Map<String, Object> params,ArrayList<String> type,StringBuilder sql) {
		 String staffID = (String)params.get("staffID");
		 if(StringUtil.checkString(staffID)) {
			 sql.append(" INNER JOIN assignmentbuilding on b.id=assignmentbuilding.buildingid ");
		 }
		 String rentAreaTo = (String)params.get("areaTo");
		 String rentAreaFrom = (String)params.get("areaFrom");
		 if(StringUtil.checkString(rentAreaTo) == true||StringUtil.checkString(rentAreaFrom) == true) {
			 sql.append(" INNER JOIN rentarea on b.id=rentarea.buildingid ");
		 }
	 }
	 
	 public static void queryNomal(Map<String,Object> params,ArrayList<String> type,StringBuilder where) {
		 for(Map.Entry<String, Object> it:params.entrySet()) {
			 if(!it.getKey().equals("staffId") && !it.getKey().equals("type") && !it.getKey().startsWith("area")) {
				 String value = it.getValue().toString();
				 if(StringUtil.checkString(value)) {
					 if(NumberUntil.isNumber(value)) {
						 where.append(" AND b." + it.getKey() + " = "+ value );
					 }
					 else {
						 where.append(" AND b." +it.getKey() +"LIKE '%" +value +"%' ");
					 }
				 }
			 }
		 }
	 }
	 public static void querySpecial(Map<String, Object> params,ArrayList<String> type,StringBuilder where) {
		 String staffId = (String)params.get("staffId");
		 if(StringUtil.checkString(staffId)) {
			 where.append(" AND assignmentbuilding.staffid = " + staffId);
		 }
		 String rentAreaTo = (String)params.get("areaTo");
		 String rentAreaFrom = (String)params.get("areaFrom");
		 
	 }
	 @Override
	 public ArrayList<BuildingEntity> findAll(Map<String, Object> params,ArrayList<String> type) {
		 StringBuilder sql= new StringBuilder("SELECT * FROM building b ");
		 StringBuilder where = new StringBuilder("WHERE 1=1 ");
		 ArrayList<BuildingEntity> result =new ArrayList<>();
		 return result;
	 }
}
