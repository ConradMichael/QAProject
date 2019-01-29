package com.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.application.model.RocketDataModel;

@Repository
public interface RocketRepository extends JpaRepository<RocketDataModel,Integer>{

}
