package com.vmo.FresherManagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmo.FresherManagement.model.Center;

public interface CenterRepo extends JpaRepository<Center, Long> {

}
