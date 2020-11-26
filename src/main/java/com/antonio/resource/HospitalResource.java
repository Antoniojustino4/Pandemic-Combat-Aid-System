package com.antonio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.repository.HospitalRepository;
import com.antonio.model.Hospital;


@RestController
@RequestMapping("/hospital")
public class HospitalResource {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@GetMapping
	public List<Hospital> listar(){
		return hospitalRepository.findAll();
	}
	
	

}
