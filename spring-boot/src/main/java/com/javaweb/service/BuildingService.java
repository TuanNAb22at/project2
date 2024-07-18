package com.javaweb.service;

import java.util.ArrayList;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entyti.BuildingEntity;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(String name,String district);
}
