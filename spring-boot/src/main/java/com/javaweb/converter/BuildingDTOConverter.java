package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entyti.BuildingEntity;


@Component
public class BuildingDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO bd = modelMapper.map(item, BuildingDTO.class);
		return bd;
	}
}
