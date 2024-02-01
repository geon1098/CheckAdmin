package com.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.check.Entity.Check;

@Repository
public interface CheckRepository extends JpaRepository<Check,Integer>{

	Check findByName(String name);
	Check findByNameAndArr(String name, String Arr);
}
