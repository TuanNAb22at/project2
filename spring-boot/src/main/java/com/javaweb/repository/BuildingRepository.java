package com.javaweb.repository;

import java.util.ArrayList;
import java.util.Map;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entyti.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);

}
