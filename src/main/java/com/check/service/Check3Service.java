package com.check.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.check.Entity.Check2;
import com.check.Entity.Check3;
import com.check.repository.Check2Repository;
import com.check.repository.CheckRepository3;

@Service
public class Check3Service {

	@Autowired
	private CheckRepository3 checkRepository3;
	
	public List<Check3> getChecks3() {
        return checkRepository3.findAll();
    }

    public Optional<Check3> getCheckById3(Integer id) {
        return checkRepository3.findById(id);
    }

    public Check3 createCheck3(Check3 check3) {
        return checkRepository3.save(check3);
    }
    public Check3 getCheck3(Integer id) {
        return checkRepository3.findById(id).orElse(null);
    }
    
    public Check3 updateCheck3(Check3 check3) {
        return checkRepository3.save(check3);
    }

    //삭제
    public void deleteCheck3(Integer id) {
        checkRepository3.deleteById(id);
    }
    
  //도착정보 갱신 서비스코드
    public void toggleArrivalStatus(Integer id) {
        Optional<Check3> optionalCheck3 = checkRepository3.findById(id);
        if (optionalCheck3.isPresent()) {
            Check3 check3 = optionalCheck3.get();
            check3.setArr("도착예정".equals(check3.getArr()) ? "도착" : "도착예정");

            // 도착 상태가 "도착"으로 설정되면 도착 시간을 업데이트합니다.
            if ("도착".equals(check3.getArr())) {
                check3.setArrtime(LocalDateTime.now());
            } else {
                check3.setArrtime(null); // 상태가 "도착"이 아니면 도착 시간을 null로 설정합니다.
            }

            checkRepository3.save(check3);
        } else {
            // 주어진 id로 Check를 찾을 수 없는 경우 처리
        }
    }
}
