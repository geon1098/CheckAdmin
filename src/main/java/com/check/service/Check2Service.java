package com.check.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.check.Entity.Check2;
import com.check.repository.Check2Repository;

@Service
public class Check2Service {

	@Autowired
	private Check2Repository check2Repository;
	
	public List<Check2> getChecks2() {
        return check2Repository.findAll();
    }

    public Optional<Check2> getCheckById2(Integer id) {
        return check2Repository.findById(id);
    }

    public Check2 createCheck2(Check2 check2) {
        return check2Repository.save(check2);
    }
    public Check2 getCheck2(Integer id) {
        return check2Repository.findById(id).orElse(null);
    }
    
    public Check2 updateCheck2(Check2 check2) {
        return check2Repository.save(check2);
    }

    //삭제
    public void deleteCheck2(Integer id) {
        check2Repository.deleteById(id);
    }
    
  //도착정보 갱신 서비스코드
    public void toggleArrivalStatus(Integer id) {
        Optional<Check2> optionalCheck2 = check2Repository.findById(id);
        if (optionalCheck2.isPresent()) {
            Check2 check2 = optionalCheck2.get();
            check2.setArr("도착예정".equals(check2.getArr()) ? "도착" : "도착예정");

            // 도착 상태가 "도착"으로 설정되면 도착 시간을 업데이트합니다.
            if ("도착".equals(check2.getArr())) {
                check2.setArrtime(LocalDateTime.now());
            } else {
                check2.setArrtime(null); // 상태가 "도착"이 아니면 도착 시간을 null로 설정합니다.
            }

            check2Repository.save(check2);
        } else {
            // 주어진 id로 Check를 찾을 수 없는 경우 처리
        }
    }
}
