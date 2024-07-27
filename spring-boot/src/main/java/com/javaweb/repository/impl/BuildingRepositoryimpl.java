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
}
