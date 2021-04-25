package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.artifact.dao.userDAO;
//import com.example.demo.domain.artifact.dto.userDTO;
import com.example.demo.domain.artifact.dto.userDTO;

@Controller
@MapperScan(basePackages = "com.example.demo.domain.artifact.dao") // 탐색할 패키시 설정(매퍼와 연결된 dao 랑 연결)
public class MainController {

	@Autowired
	private userDAO dao;

	// 뷰 보여주는 컨트롤러
	@GetMapping("/")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView("/ajaxTest");

		return mav;
	}

	// 뷰 보여주는 컨트롤러
	@GetMapping("/2")
	public ModelAndView index2() throws Exception {
		ModelAndView mav = new ModelAndView("/ajaxTest2");

		return mav;
	}

	// 쿼리 처리 후 결과 뷰 보여주는 컨트롤러
	@GetMapping("/ajaxTest.do")
	public ModelAndView ajaxTest(userDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView("/ajaxTestResult");

		List<userDTO> userList = dao.selectIdName(dto);

		for (userDTO list : userList) {
			System.out.println("회원 ID : " + list.getId());
			System.out.println("회원 NAME : " + list.getName());

		}

		mav.addObject("list", userList);

		return mav;
	}

	// 쿼리 처리 후 결과 뷰 보여주는 컨트롤러
	@GetMapping("/ajaxTest2.do")
	public ModelAndView ajaxTest2(userDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView("/ajaxTestResult2");

		userDTO one = dao.selectone(dto);

		mav.addObject("one", one);

		return mav;
	}

	// 뷰 보여주는 컨트롤러
	@GetMapping("/3")
	public ModelAndView index3() throws Exception {
		ModelAndView mav = new ModelAndView("/ajaxTestResult3");

		return mav;
	}
	
	    // 에이젝스 컨트롤러 
	    @RequestMapping(value = "/ajax", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
		@ResponseBody
		public ModelAndView ajax(userDTO dto) throws Exception { // a 변수명은 에이젝스에서 보내는 data 첫번째 명과 매핑 -> data : 매핑 : js사용 이름
			ModelAndView mav = new ModelAndView();
			mav.setViewName("jsonView");
			
			List<userDTO> result = dao.ajax(dto); //값이 여러 줄이면 List 로 리턴 , 1줄이면 String
			for (userDTO list1 : result) {
				System.out.println("뭐가 나올까1 : " +list1.toString());
			}
			System.out.println("뭐가 나올까1 : " + result);
			
			List<String> ajax = new ArrayList<>(); //값이 여러 줄이면 List 로 리턴 , 1줄이면 String
			for (String list2 : ajax) {
				System.out.println("뭐가 나올까2 : " +list2.toString());
			}
			
			//ajax.addAll(result);
			mav.addObject("result", result);
			
			//mav.addObject("ajax", ajax); // "명찰"로 보내는 이름은 에이젝스에서 받을 때 data."명찰"과 매핑

			return mav;
		}

}
