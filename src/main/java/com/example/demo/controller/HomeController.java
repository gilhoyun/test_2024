package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
private MemberService memberService;
	
HomeController( MemberService memberService){
		this.memberService = memberService;
	}
	
	@GetMapping("/usr/home/main")
	public String showMain(HttpSession session, Model model) {
		
		int loginedMemberId = -1;
		
		
		if(session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int)session.getAttribute("loginedMemberId");
			
		}
		
		 model.addAttribute("loginedMemberId", loginedMemberId);
		
		return "usr/home/main";
	}
	
	@GetMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}

}
