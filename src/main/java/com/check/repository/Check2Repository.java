package com.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.check.Entity.Check2;

@Repository
public interface Check2Repository extends JpaRepository<Check2, Integer>{

}
