package com.tianyl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.entity.BarEntity;
import com.tianyl.repository.BarRepository;

@Service
public class BarService {

	@Autowired
	private BarRepository barRepository;

	@Autowired
	private UserService userService;

	public List<BarEntity> findAll() {
		return barRepository.findAll();
	}

	@Transactional
	public void save(BarEntity entity) {
		barRepository.save(entity);
	}

}
