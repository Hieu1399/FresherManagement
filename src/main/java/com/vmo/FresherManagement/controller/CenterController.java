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

import com.vmo.FresherManagement.dao.CenterDAO;
import com.vmo.FresherManagement.model.Center;

@RestController
@RequestMapping("/management")
public class CenterController {
	@Autowired
	CenterDAO centerDAO;
	
	/* to save an center*/
	@PostMapping("/center")
	public Center createCenter(@Valid @RequestBody Center center) {
		return centerDAO.save(center);
	}
	
	/*get all center*/
	@GetMapping("/center")
	public List<Center> getAll(){
		return centerDAO.findAll();
	}
	
	/*get fresher by id*/
	@GetMapping("/center/{id}")
	public ResponseEntity<Center> getById(@PathVariable(value="id") Long id){
		Center center = centerDAO.findById(id);
		if(center ==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(center);
	}
	
	
	/*update an center by id*/
	@PutMapping("/center/{id}")
	public ResponseEntity<Center> updateCenter(@PathVariable(value="id") Long freid,@Valid @RequestBody Center centerDetail){
		
		Center center=centerDAO.findById(freid);
		if(center==null) {
			return ResponseEntity.notFound().build();
		}
		
		center.setName(centerDetail.getName());
		center.setAddress(centerDetail.getAddress());
		center.setMail(centerDetail.getMail());
		center.setPhone(centerDetail.getPhone());
		
		Center updateCenter =centerDAO.save(center);
		return ResponseEntity.ok().body(updateCenter);
		
	}
	
	/*Delete an center*/
	@DeleteMapping("/center/{id}")
	public ResponseEntity<Center> deleteCenter(@PathVariable(value="id") Long id){
		
		Center center=centerDAO.findById(id);
		if(center==null) {
			return ResponseEntity.notFound().build();
		}
		centerDAO.delete(center);
		
		return ResponseEntity.ok().build();
			
	}
}
