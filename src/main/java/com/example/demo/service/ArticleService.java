package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;

@Service
public class ArticleService {
	
private ArticleDao articleDao;
	
	public ArticleService( ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List<Article> showList() {
		return articleDao.showList();		
	}

	public int lastArticleId() {
		return articleDao.lastArticleId();
	}

	public void writeArticle(int loginedMemberId, String title, String body) {
		articleDao.writeArticle(loginedMemberId, title, body); 

		
	}

	public Article showDetail(int id) {
		return articleDao.showDetail(id);
	}
}
