package com.vmo.FresherManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.FresherManagement.dao.FresherDAO;
import com.vmo.FresherManagement.model.Fresher;

@RestController
@RequestMapping("/management")
public class FresherController {

	@Autowired
	FresherDAO fresherDAO;
	
	/* to save an fresher*/
	@PostMapping("/fresher")
	public Fresher createFresher(@Valid @RequestBody Fresher fre) {
		return fresherDAO.save(fre);
	}
	
	/*get all fresher*/
	@GetMapping("/fresher")
	public List<Fresher> getAll(){
		return fresherDAO.findAll();
	}
	
	/*get fresher by freid*/
	@GetMapping("/fresher/{id}")
	public ResponseEntity<Fresher> getById(@PathVariable(value="id") Long freid){
		Fresher fre = fresherDAO.findById(freid);
		if(fre ==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(fre);
	}
	
	/*get fresher by name*/
	@RequestMapping("/fresher/name/{name}")
	public Fresher getByName(@PathVariable(value="name") String frename){
		return fresherDAO.getByName(frename);
		
	}
	
	/*update an fresher by freid*/
	@PutMapping("/fresher/{id}")
	public ResponseEntity<Fresher> updateFresher(@PathVariable(value="id") Long freid,@Valid @RequestBody Fresher freDetails){
		
		Fresher fre=fresherDAO.findById(freid);
		if(fre==null) {
			return ResponseEntity.notFound().build();
		}
		
		fre.setName(freDetails.getName());
		fre.setPhone(freDetails.getPhone());
		fre.setMail(freDetails.getMail());
		fre.setLanguage(freDetails.getLanguage());
		
		Fresher updateFresher=fresherDAO.save(fre);
		return ResponseEntity.ok().body(updateFresher);
		
	}
	
	/*Delete an fresher*/
	@DeleteMapping("/fresher/{id}")
	public ResponseEntity<Fresher> deleteFresher(@PathVariable(value="id") Long freid){
		
		Fresher fre=fresherDAO.findById(freid);
		if(fre==null) {
			return ResponseEntity.notFound().build();
		}
		fresherDAO.delete(fre);
		
		return ResponseEntity.ok().build();
			
	}
	
}
