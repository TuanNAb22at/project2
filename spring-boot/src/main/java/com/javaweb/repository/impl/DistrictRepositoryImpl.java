package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entyti.DistrictEntity;
import com.javaweb.utils.ConnectionJDBCUtil;

public class DistrictRepositoryImpl implements DistrictRepository {
	
	@Override
	public DistrictEntity findNameById(Long id) {
		String sql="select d.name FROM district WHERE d.id = "+ id;
		DistrictEntity districtEntity = new DistrictEntity();
		try(Connection conn=ConnectionJDBCUtil.getConnection();
				java.sql.Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
			){
			while(rs.next()) {
				districtEntity.setName(rs.getString("name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.print("faild");
		}
		return districtEntity;
	}
}