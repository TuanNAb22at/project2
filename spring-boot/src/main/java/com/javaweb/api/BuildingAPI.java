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
	@DeleteMapping(value="/api/building/{id}/{name}")
	public void deleteBuilding(@PathVariable Integer id,
							  @PathVariable String name) {
		System.out.println("da xoa"+id+" "+name);
	}
	
}
