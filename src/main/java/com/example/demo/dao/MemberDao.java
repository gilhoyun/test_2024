package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {

	@Insert("""
			INSERT INTO `member`
			SET regDate = NOW()
			, updateDate = NOW()
			, email = #{email}
			, loginPw = #{loginPw}
			, `name` = #{name}
			""")
	void memberJoin(String email, String loginPw, String name);

	@Select("""
			SELECT *
			  FROM `member`
			WHERE email = #{email}
			""")
	Member getLoginedId(String email);

	@Select("""
			SELECT *
			  FROM `member`
			WHERE id = #{loginedMemberId}  
			""")
	Member getLoginedMember(int loginedMemberId);

	
	@Update("""
			UPDATE `member`
			SET `name` = #{name}
			WHERE id = #{loginedMemberId}
			""")
	void modifyMember(int loginedMemberId, String name);

}
