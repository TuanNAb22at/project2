package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.Map;

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
	public ArrayList<BuildingDTO> findAll(Map<String, Object> params,ArrayList<String> type){
		return null;
	}
}
