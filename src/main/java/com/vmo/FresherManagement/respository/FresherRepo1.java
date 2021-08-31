package com.vmo.FresherManagement.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vmo.FresherManagement.model.Fresher;

public interface FresherRepo1 extends CrudRepository<Fresher, String>{
	public List<Fresher> findByName(String name);
}
