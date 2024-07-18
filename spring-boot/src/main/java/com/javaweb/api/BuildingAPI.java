package com.javaweb.api;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;


@RestController
public class BuildingAPI {
	 @Autowired
	 private BuildingService buildingService;
	@GetMapping(value="/api/building")
	public ArrayList<BuildingDTO> getBuilding(@RequestParam(value="name",required=false) String name,
												@RequestParam(value="district",required=false) String district) {
		ArrayList<BuildingDTO> result =buildingService.findAll(name,district);
		return result;
	}
	
}
