package com.check.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.check.Entity.Check;
import com.check.Entity.Check2;
import com.check.Entity.Check3;
import com.check.Entity.VolunList;
import com.check.Entity.VolunList2;
import com.check.Entity.VolunList3;
import com.check.repository.Check2Repository;
import com.check.repository.CheckRepository;
import com.check.repository.CheckRepository3;
import com.check.service.Check2Service;
import com.check.service.Check3Service;
import com.check.service.CheckService;
import com.check.service.VolunService;
import com.check.service.VolunService2;
import com.check.service.VolunService3;


@Controller
public class CheckController {

    @Autowired
    private CheckService checkService;
    
    @Autowired
    private Check2Service check2Service;
    
    @Autowired
    private Check3Service check3Service;
    
    @Autowired
    private VolunService volunService;
    
    @Autowired
    private VolunService2 volunService2;
    
    @Autowired
    private VolunService3 volunService3;
    
    private final CheckRepository checkRepository;
    
    private final Check2Repository check2Repository;
    
    private final CheckRepository3 checkRepository3;

    public CheckController(CheckRepository checkRepository, Check2Repository check2Repository, CheckRepository3 checkRepositry3) {
        this.checkRepository = checkRepository;
        this.check2Repository = check2Repository;
        this.checkRepository3 = checkRepositry3;
    }

    
    @GetMapping("/checks")
    public String getChecks(Model model) {
        List<Check> checks = checkService.getChecks();
        List<Check2> checks2 = check2Service.getChecks2();
        List<Check3> checks3 = check3Service.getChecks3();
        List<VolunList> volunList = volunService.getVolun();
        List<VolunList2> volunList2 = volunService2.getVolun2();
        List<VolunList3> volunList3 = volunService3.getVolun3();
        model.addAttribute("volunList", volunList);
        model.addAttribute("volunList2",volunList2);
        model.addAttribute("volunList3",volunList3);
        model.addAttribute("checks", checks);
        model.addAttribute("checks2", checks2);
        model.addAttribute("checks3", checks3);
        return "checklist";
    }

    @GetMapping("/{id}")// 한 정보 읽기
    public Check getCheckById(@PathVariable("id") Integer id) {
    	return checkService.getCheckById(id).orElse(null);
    }
    @GetMapping("/listcreate")
    public String listCreateForm() {
        return "listcreate"; // create.html로 이동
    }
    @PostMapping("/listcreate")
    public String listcreateCheck(Model model, VolunList volunList) {
    	volunService.createCheck(volunList);
        model.addAttribute("message", "완료");
        model.addAttribute("searchUrl", "/checks");
        return "message";
    }
    //게시판2 정보 생성 시작
    @GetMapping("/listcreate2")
    public String listCreateForm2() {
        return "listcreate2"; // create.html로 이동
    }
    @PostMapping("/listcreate2")
    public String listcreateCheck2(Model model, VolunList2 volunList2) {
    	volunService2.createCheck(volunList2);
        model.addAttribute("message", "완료");
        model.addAttribute("searchUrl", "/checks");
        return "message";
    }
    // 게시판2 정보 생성 끝
    
  //	게시판3 정보 생성 시작
	
	   @GetMapping("/listcreate3") 
	   public String listCreateForm3() { 
		   return "listcreate3"; // create.html로 이동 
	   }
	  
	   @PostMapping("/listcreate3") 
	   public String listcreateCheck3(Model model, VolunList3 volunList3) { 
		volunService3.createCheck(volunList3);
		model.addAttribute("message", "완료");
		model.addAttribute("searchUrl","/checks"); 
		return "message"; }
	 
    // 게시판3 정보 생성 끝
    
    @GetMapping("/create")
    public String showCreateForm() {
        return "create"; // create.html로 이동
    }

    @PostMapping("/create")
    public String createCheck(Model model, Check check) {
    	checkService.createCheck(check);
        model.addAttribute("message", "완료");
        model.addAttribute("searchUrl", "/checks");
        return "message";
    }
    
    //checks2 테이블 생성 구성코드 시작
    @GetMapping("/create2")
    public String showCreateForm2() {
        return "create2"; // create.html로 이동
    }
    
    @PostMapping("/create2")
    public String createCheck2(Model model, Check2 check2) {
    	check2Service.createCheck2(check2);
        model.addAttribute("message", "완료");
        model.addAttribute("searchUrl", "/checks");
        return "message";
    }
    //checks2 테이블 생성 구성코드 끝
    
  //checks2 테이블 생성 구성코드 시작
    @GetMapping("/create3")
    public String showCreateForm3() {
        return "create3"; // create.html로 이동
    }
    
    @PostMapping("/create3")
    public String createCheck3(Model model, Check3 check3) {
    	check3Service.createCheck3(check3);
        model.addAttribute("message", "완료");
        model.addAttribute("searchUrl", "/checks");
        return "message";
    }
    //checks2 테이블 생성 구성코드 끝

    @PutMapping("/{id}")// 정보 갱신
    public Check updateCheck(@PathVariable("id") Integer id, @RequestBody Check check) {
        check.setId(id);
        return checkService.updateCheck(check);
    }

    @GetMapping("/edit/{id}") // 봉사자 체크 수정을 위한 정보 조회
    public String getCheck(@PathVariable("id") Integer id, Model model) {
        Check check = checkService.getCheck(id);
        model.addAttribute("check", check);
        return "edit"; // 수정을 위한 뷰 페이지로 이동
    }
    
    @PostMapping("/edit/{id}")
    public String editCheck(@PathVariable("id") Integer id, @ModelAttribute("check") Check check, Model model) {
        check.setId(id);
        checkService.updateCheck(check);
        return "redirect:/checks";
    }
    
    //check2 정보 갱신 시작		check2 정보 갱신 시작		check2 정보 갱신 시작
    @PutMapping("/edit2/{id}") // check2 정보 갱신
    public Check2 updateCheck2(@PathVariable("id") Integer id, @RequestBody Check2 check2) {
        check2.setId(id);
        return check2Service.updateCheck2(check2);
    }
    
    @GetMapping("/edit2/{id}") // 봉사자 체크 수정을 위한 정보 조회
    public String getCheck2(@PathVariable("id") Integer id, Model model) {
        Check2 check2 = check2Service.getCheck2(id);
        model.addAttribute("check2", check2);
        return "edit2"; // 수정을 위한 뷰 페이지로 이동
    }
    
    @PostMapping("/edit2/{id}")
    public String editCheck2(@PathVariable("id") Integer id, @ModelAttribute("check2") Check2 check2, Model model) {
        check2.setId(id);
        check2Service.updateCheck2(check2);
        return "redirect:/checks";
    }
  //check2 정보 갱신 시작 끝   check2 정보 갱신 시작 끝		check2 정보 갱신 시작 끝
    

    @GetMapping("/delete/{id}")// 정보 삭제
    public String deleteCheck(@PathVariable("id") Integer id) {
        checkService.deleteCheck(id);
        return "redirect:/checks";
    }
    
    @GetMapping("/delete2/{id}")// 정보 삭제
    public String deleteCheck2(@PathVariable("id") Integer id) {
        check2Service.deleteCheck2(id);
        return "redirect:/checks";
    }
    
    
    @GetMapping("/toggleArrival/{id}")
    public String toggleArrivalStatus(@PathVariable("id") Integer id) {
        checkService.toggleArrivalStatus(id);
        return "redirect:/checks";
    }
    
    @GetMapping("/toggleArrival2/{id}")
    public String toggleArrivalStatus2(@PathVariable("id") Integer id) {
        check2Service.toggleArrivalStatus(id);
        return "redirect:/checks";
    }
    @GetMapping("/toggleArrival3/{id}")
    public String toggleArrivalStatus3(@PathVariable("id") Integer id) {
        check3Service.toggleArrivalStatus(id);
        return "redirect:/checks";
    }
    
    @PostMapping("/updateArrival")
    @ResponseBody
    public Map<String, String> updateArrival(@RequestParam("id") Integer id, @RequestParam("newArrivalStatus") String newArrivalStatus) {
        Optional<Check> optionalCheck = checkRepository.findById(id);
        if (optionalCheck.isPresent()) {
            Check check = optionalCheck.get();
            check.setArr(newArrivalStatus);
            checkRepository.save(check);

            Map<String, String> result = new HashMap<>();
            result.put("status", "success");
            return result;
        } else {
            Map<String, String> result = new HashMap<>();
            result.put("status", "error");
            return result;
        }
        
        
    }
    
    
}
