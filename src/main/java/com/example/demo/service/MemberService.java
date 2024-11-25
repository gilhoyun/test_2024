package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

@Service
public class MemberService {
	
private MemberDao memberDao;
	
	public MemberService( MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void memberJoin(String email, String loginPw, String name) {
		memberDao.memberJoin(email, loginPw, name);
		
	}
	public Member getLoginedId(String email) {
		return memberDao.getLoginedId(email);
	}

	public Member getLoginedMember(int loginedMemberId) {
		return memberDao.getLoginedMember(loginedMemberId);
	}

	public void modifyMember(int loginedMemberId, String name) {
		memberDao.modifyMember(loginedMemberId, name);
	}

}
