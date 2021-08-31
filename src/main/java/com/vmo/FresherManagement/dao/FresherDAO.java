package com.vmo.FresherManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.FresherManagement.model.Fresher;
import com.vmo.FresherManagement.respository.FresherRepo;
import com.vmo.FresherManagement.respository.FresherRepo1;

@Service
public class FresherDAO {
	@Autowired 
	FresherRepo fresherRepo;
	FresherRepo1 fresherRepo1;
	
	public Fresher save(Fresher fre) {
		return fresherRepo.save(fre);
	}
	
	public List<Fresher> findAll(){
		return fresherRepo.findAll();
	}
	
	public Fresher findById(Long id) {
		return fresherRepo.findOne(id);
	}
	public Fresher getByName(String name) {
		return  fresherRepo1.findOne(name);
	}
	
	public void delete(Fresher fre) {
		fresherRepo.delete(fre);
	}
}
