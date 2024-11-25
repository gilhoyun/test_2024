package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ArticleService;
import com.example.demo.service.ReplyService;
import com.example.demo.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReplyController {
	
	private ReplyService replyService;
	
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	
	
	@PostMapping("/usr/reply/doWrite")
	@ResponseBody
	public String doWrite(HttpSession session, String relTypeCode, int relId, String body, Model model) {
		
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}
		
		replyService.replyWrite(loginedMemberId, relTypeCode, relId, body);
		
		model.addAttribute("loginedMemberId", loginedMemberId);
		
		return Util.jsReturn("댓글 작성을 완료했습니다", String.format("../article/detail?id=%d", relId));
	}

}
