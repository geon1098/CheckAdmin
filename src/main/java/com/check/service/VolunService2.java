package com.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.check.Entity.VolunList2;
import com.check.repository.VolunRepository2;

@Service
public class VolunService2 {

	@Autowired
	private VolunRepository2 volunRepository2;
	
	public VolunList2 createCheck(VolunList2 volunList2) {
		
		return volunRepository2.save(volunList2);
	}
	
	public List<VolunList2> getVolun2(){
		
		return volunRepository2.findAll();
	}
}
