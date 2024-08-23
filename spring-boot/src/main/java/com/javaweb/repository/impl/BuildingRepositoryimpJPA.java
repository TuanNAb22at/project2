package com.javaweb.repository.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entyti.BuildingEntity;
@Repository
public class BuildingRepositoryimpJPA implements BuildingRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		String sql="select * FROM building b where b.name like '%Giao%' ";
		/*Query query = entityManager.createQuery(sql,BuildingEntity.class);
		return (ArrayList<BuildingEntity>) query.getResultList(); JPQL*/
		//SQL Native
		Query query = entityManager.createNativeQuery(sql,BuildingEntity.class);
		return (ArrayList<BuildingEntity>) query.getResultList();
	}
	
}
