package com.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.check.Entity.Check3;

@Repository
public interface CheckRepository3 extends JpaRepository<Check3, Integer>{

}
