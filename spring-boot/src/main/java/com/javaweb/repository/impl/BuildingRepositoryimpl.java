package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.springframework.stereotype.Repository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	 static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	 static final String USER = "root";
	 static final String PASS = "12345";
	@Override
	public ArrayList<BuildingEntity> findAll(String name,String district) {
		StringBuilder sql=new StringBuilder("SELECT * FROM building b where 1=1 ");
		if(name!=null && !name.equals("")) {
			sql.append("AND b.name like '%" + name +"%' ");
		}
		if(district !=null && !district.equals("")) {
			sql.append("AND b.district like '%" + district +"%' ");
		}
		
		ArrayList<BuildingEntity> arr =new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				java.sql.Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql.toString());
			){
			while(rs.next()) {
				BuildingEntity building =new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfbasement(rs.getInt("numberofbasement"));
				arr.add(building);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.print("faild");
		}
		return arr;
	}
	
	
}
