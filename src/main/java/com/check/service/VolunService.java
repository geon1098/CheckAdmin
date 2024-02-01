package com.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.check.Entity.VolunList;
import com.check.repository.VolunRepository;

@Service
public class VolunService {

	@Autowired
	private VolunRepository volunRepository;
	
	
	public VolunList createCheck(VolunList volunList) {
		
		return volunRepository.save(volunList);
	}
	
	public List<VolunList> getVolun(){
		
		return volunRepository.findAll();
	}
}
