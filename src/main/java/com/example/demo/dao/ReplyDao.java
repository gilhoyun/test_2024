package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.Reply;

@Mapper
public interface ReplyDao {

	
	@Insert("""
			INSERT INTO reply
	        SET regDate = NOW()
            , updateDate = NOW()
            , memberId = #{loginedMemberId}
            , relTypeCode = #{relTypeCode}
            , relId = #{relId}
            , `body` = #{body}
			""")
	void replyWrite(int loginedMemberId, String relTypeCode, int relId, String body);

	
	@Select("""
			SELECT reply.* , member.name
			FROM reply
			INNER JOIN `member`
			ON reply.memberId = member.id
			WHERE relTypeCode = #{relTypeCode}
			AND relId = #{id}
			""")
	List<Reply> showReply(String relTypeCode, int id);

}
