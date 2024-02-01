package com.check.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "checks3")
@Getter
@Setter
public class Check3 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10,nullable = false)
    private String name; // 이름

    @Column(length = 13,nullable = false)
    private String phone; // 폰번호

    @Column(length = 4,nullable = false)
    private String arr; // 도착 정보
    
    private LocalDateTime arrtime;	// 도착시간

    private String memo; // 비고

}
