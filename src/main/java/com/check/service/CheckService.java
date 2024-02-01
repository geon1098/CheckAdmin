package com.check.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.check.Entity.Check;
import com.check.repository.CheckRepository;

@Service
public class CheckService {

    @Autowired
    private CheckRepository checkRepository;

    
    public List<Check> getChecks() {
        return checkRepository.findAll();
    }

    public Optional<Check> getCheckById(Integer id) {
        return checkRepository.findById(id);
    }

    public Check createCheck(Check check) {
        return checkRepository.save(check);
    }
    public Check getCheck(Integer id) {
        return checkRepository.findById(id).orElse(null);
    }
    
    public Check updateCheck(Check check) {
        return checkRepository.save(check);
    }

    //삭제
    public void deleteCheck(Integer id) {
        checkRepository.deleteById(id);
    }
    
    //도착정보 갱신 서비스코드
    public void toggleArrivalStatus(Integer id) {
        Optional<Check> optionalCheck = checkRepository.findById(id);
        if (optionalCheck.isPresent()) {
            Check check = optionalCheck.get();
            check.setArr("도착예정".equals(check.getArr()) ? "도착" : "도착예정");

            // 도착 상태가 "도착"으로 설정되면 도착 시간을 업데이트합니다.
            if ("도착".equals(check.getArr())) {
                check.setArrtime(LocalDateTime.now());
            } else {
                check.setArrtime(null); // 상태가 "도착"이 아니면 도착 시간을 null로 설정합니다.
            }

            checkRepository.save(check);
        } else {
            // 주어진 id로 Check를 찾을 수 없는 경우 처리
        }
    }
}
