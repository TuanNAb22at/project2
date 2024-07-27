package com.javaweb.api;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrotResponseDTO;
import com.javaweb.service.BuildingService;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

@RestController

public class BuildingAPI {
	 @Autowired
	 private BuildingService buildingService;
	@GetMapping(value="/api/building")
	public ArrayList<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
		   @RequestParam(value="type",required =false) ArrayList<String> type) 	{
		ArrayList<BuildingDTO> result =buildingService.findAll(params,type);
		return result;
	}
	
	@DeleteMapping(value="/api/building/{id}/{name}")
	public void deleteBuilding(@PathVariable Integer id,
							  @PathVariable String name) {
		System.out.println("da xoa"+id+" "+name);
	}
	
}
