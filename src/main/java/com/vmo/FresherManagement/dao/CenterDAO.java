package com.vmo.FresherManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.FresherManagement.model.Center;
import com.vmo.FresherManagement.respository.CenterRepo;

@Service
public class CenterDAO {
	@Autowired 
	CenterRepo centerRepo;
	
	
	public Center save(Center center) {
		return centerRepo.save(center);
	}
	
	public List<Center> findAll(){
		return centerRepo.findAll();
	}
	
	public Center findById(Long id) {
		return centerRepo.findOne(id);
	}
	
	public void delete(Center center) {
		centerRepo.delete(center);
	}
}
