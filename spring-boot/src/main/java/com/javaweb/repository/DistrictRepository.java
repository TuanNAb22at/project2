package com.javaweb.repository;

import com.javaweb.repository.entyti.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findNameById(Long id);
}
