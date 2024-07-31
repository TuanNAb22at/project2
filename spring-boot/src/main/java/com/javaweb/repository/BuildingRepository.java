package com.javaweb.repository;

import java.util.ArrayList;
import java.util.Map;

import com.javaweb.repository.entyti.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(Map<String, Object> params, ArrayList<String> type);
}
