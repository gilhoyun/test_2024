package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dto.Article;
import com.example.demo.dto.Member;
import com.example.demo.dto.Reply;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ReplyService;
import com.example.demo.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	private ReplyService replyService;
	
	public ArticleController(ArticleService articleService, ReplyService replyService) {
		this.articleService = articleService;
		this.replyService = replyService;
	}
	
	@GetMapping("/usr/article/write")
	public String login() {

		return "usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite")
	@ResponseBody
	public String doLogin(HttpSession session, String title, String body) {

		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}
		
		articleService.writeArticle(loginedMemberId, title, body);
				
		int id = articleService.lastArticleId();

		return Util.jsReturn(String.format("%d번 게시물을 작성했습니다.", id), "list");
	}
	
	@GetMapping("/usr/article/list")
	public String list(HttpSession session, Model model) {
		
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}
		
		List<Article> article = articleService.showList();
		
		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", loginedMemberId);
       
		return "usr/article/list";
	}
	
	
	@GetMapping("/usr/article/detail")
	public String detail(HttpSession session, Model model, int id) {
		
		int loginedMemberId = -1;

		if (session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) session.getAttribute("loginedMemberId");

		}
		
		Article article = articleService.showDetail(id);
		
		List<Reply> replies = replyService.showReply("article", id);
		
		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", loginedMemberId);
		model.addAttribute("replies", replies);

		
		return "usr/article/detail";
	}
	
	

}
