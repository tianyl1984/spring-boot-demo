package com.tianyl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tianyl.entity.BarEntity;

@Repository
public class BarRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public List<BarEntity> findByNames(String... name) {
		em.createQuery("");
		return null;
	}

}
