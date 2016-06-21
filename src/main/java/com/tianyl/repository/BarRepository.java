package com.tianyl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tianyl.entity.BarEntity;

@Repository
public interface BarRepository extends JpaRepository<BarEntity, Long> {

}
