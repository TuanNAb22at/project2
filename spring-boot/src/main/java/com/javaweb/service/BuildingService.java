package com.javaweb.service;

import java.util.ArrayList;
import java.util.Map;

import com.javaweb.builder.BuildingSearchBuider;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entyti.BuildingEntity;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(Map<String, Object> params,ArrayList<String> type);
}
