package com.spring.application.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.application.exception.ResourceNotFoundException;
import com.spring.application.model.RocketDataModel;
import com.spring.application.repository.RocketRepository;

@RestController
@RequestMapping("/api")
public class RocketController {

	@Autowired
	RocketRepository myRepository;
	
	@CrossOrigin
	@GetMapping("/launches")
	public List<RocketDataModel> getAllFilms(){
		return myRepository.findAll();
	}
	
	@PostMapping("/addLaunch")
	public RocketDataModel addLaunch( @RequestBody RocketDataModel RDM) {
		System.out.println(RDM);
		
		return myRepository.save(RDM);
	}
	
	@DeleteMapping("/deleteLaunch/{id}")
	public ResponseEntity<?> deleteLaunch(@PathVariable(value = "id") Integer id){
		RocketDataModel deleteLaunch = myRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Launch", "id", id));
		myRepository.delete(deleteLaunch);
		
		return ResponseEntity.ok().build();
	}

}
