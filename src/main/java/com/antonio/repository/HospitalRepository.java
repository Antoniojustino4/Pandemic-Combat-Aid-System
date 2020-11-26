package com.antonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonio.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
