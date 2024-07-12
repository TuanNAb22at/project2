package com.javaweb.repository;

import java.util.ArrayList;

import com.javaweb.repository.entyti.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(String name);
}
