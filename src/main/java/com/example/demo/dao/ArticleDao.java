package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleDao {

	@Select("""
			SELECT article.*, member.name
			FROM article
			INNER JOIN `member`
			ON article.memberId = member.id
			ORDER BY article.id DESC
			""")
	List<Article> showList();

	@Select("""
			SELECT LAST_INSERT_ID()
			""")
	int lastArticleId();

	@Insert("""
			INSERT INTO article
	        SET regDate = NOW()
			, updateDate = NOW()
			, memberId = #{loginedMemberId}
			, title = #{title}
			, `body` = #{body}
			""")
	void writeArticle(int loginedMemberId, String title, String body);

	@Select("""
			SELECT *, member.name
			FROM article
			INNER JOIN `member`
			ON article.memberId = member.id
			WHERE article.id = #{id}
			""")
	Article showDetail(int id);

}
