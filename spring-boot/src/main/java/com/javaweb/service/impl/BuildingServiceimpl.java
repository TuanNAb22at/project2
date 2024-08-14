package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class BuildingServiceimpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private  BuildingDTOConverter buildingDTOConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public ArrayList<BuildingDTO> findAll(Map<String, Object> params,ArrayList<String> type) {
		BuildingSearchBuilder buildingSearchBuilder=buildingSearchBuilderConverter.toBuildingSearchBuilder(params, type);
		ArrayList<BuildingEntity> buildingentities =buildingRepository.findAll(buildingSearchBuilder);
		ArrayList<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item:buildingentities) {
			BuildingDTO bd = buildingDTOConverter.toBuildingDTO(item);
			result.add(bd);
		}
		return result;
	}

}
