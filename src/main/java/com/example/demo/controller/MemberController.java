package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import com.example.demo.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/usr/member/join")
	public String join() {

		return "usr/member/join";
	}

	@PostMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(String email, String loginPw, String name) {

		Member member = memberService.getLoginedId(email);

		if (member != null) {
			return Util.jsReturn(String.format("[ %s ]은(는) 이미 사용중인 이메일입니다.", member.getEmail()), "join");
		}

		memberService.memberJoin(email, loginPw, name);

		return Util.jsReturn(String.format("[ %s ]님 가입을 환영합니다.", email), "/");
	}

	@GetMapping("/usr/member/login")
	public String login() {

		return "usr/member/login";
	}

	@PostMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession session, String email, String loginPw) {

		Member member = memberService.getLoginedId(email);

		if (member == null) {
			return Util.jsReturn("존재 하지 않는 회원입니다.", null);
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Util.jsReturn("비밀번호가 일치하지 않습니다.", null);
		}

		session.setAttribute("loginedMemberId", member.getId());

		return Util.jsReturn(String.format("[ %s ]님 환영합니다.", email), "/");
	}

	@GetMapping("/usr/member/myPage")
	public String myPage(HttpSession session, Model model) {

		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}

		Member member = memberService.getLoginedMember(loginedMemberId);

		model.addAttribute("member", member);

		return "usr/member/myPage";
	}

	@GetMapping("/usr/member/modifyPage")
	public String modifyPage(HttpSession session, Model model) {

		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}

		Member member = memberService.getLoginedMember(loginedMemberId);

		model.addAttribute("member", member);

		return "usr/member/modifyPage";
	}
	
	@PostMapping("/usr/member/doModifyPage")
	@ResponseBody
	public String doModifyPage(HttpSession session, Model model, String name) {

		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}

		Member member = memberService.getLoginedMember(loginedMemberId);
		
		memberService.modifyMember(loginedMemberId, name);

		model.addAttribute("member", member);

		return Util.jsReturn("정보가 수정되었습니다.", "myPage");
	}
	
	@GetMapping("/usr/member/logout")
	@ResponseBody
	public String logout(HttpSession session) {

		session.removeAttribute("loginedMemberId");

		return Util.jsReturn("로그아웃 되었습니다.", "/");
	}

}
