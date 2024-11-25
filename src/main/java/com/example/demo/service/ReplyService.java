package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ReplyDao;
import com.example.demo.dto.Reply;



@Service
public class ReplyService {
	
private ReplyDao replyDao;
	
	public ReplyService( ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public void replyWrite(int loginedMemberId, String relTypeCode, int relId, String body) {
		replyDao.replyWrite(loginedMemberId, relTypeCode, relId, body);
		
	}

	public List<Reply> showReply(String relTypeCode, int id) {
		return replyDao.showReply(relTypeCode, id);
	}

}
