package com.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.check.Entity.VolunList;
import com.check.Entity.VolunList3;
import com.check.repository.VolunRepository;
import com.check.repository.VolunRepository3;

@Service
public class VolunService3 {

	@Autowired
	private VolunRepository3 volunRepository3;
	
	
	public VolunList3 createCheck(VolunList3 volunList3) {
		
		return volunRepository3.save(volunList3);
	}
	
	public List<VolunList3> getVolun3(){
		
		return volunRepository3.findAll();
	}
}
