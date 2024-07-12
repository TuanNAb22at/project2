package com.javaweb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class BuildingServiceimpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public ArrayList<BuildingDTO> findAll(String name) {
		ArrayList<BuildingEntity> buildingentities =buildingRepository.findAll(name);
		ArrayList<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item:buildingentities) {
			BuildingDTO bd =new BuildingDTO();
			bd.setName(item.getName());
			bd.setNumberOfbasement(item.getNumberOfbasement());
			bd.setAddress(item.getStreet()+" , "+item.getWard());
			result.add(bd);
		}
		return result;
	}

}
