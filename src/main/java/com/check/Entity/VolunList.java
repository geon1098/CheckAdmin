package com.check.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "list")
@Getter
@Setter
public class VolunList { // 봉사자 정보 리스트 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer v_id;

    @Column(nullable = false)
    private String listname; // 제목

    @Column(nullable = false)
    private String time; // 시작 시간 끝 시간 적는곳

    @Column(nullable = false)
    private String place; // 장소

    private String note; // 내용

    private String name; // 추가된 부분
    
    @OneToMany(mappedBy = "volunList")
    private List<Check> checks;
}