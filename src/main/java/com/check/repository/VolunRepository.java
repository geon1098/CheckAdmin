package com.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.check.Entity.VolunList;

@Repository
public interface VolunRepository extends JpaRepository<VolunList,Integer>{

}
