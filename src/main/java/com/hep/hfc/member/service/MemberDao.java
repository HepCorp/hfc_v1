package com.hep.hfc.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hep.hfc.member.MemberVO;

@Repository("memberDAO")
public class MemberDao {

	private String namespace = "memberMapper.";
	
	@Autowired
	SqlSessionTemplate session;
	
	public MemberVO loginSelect(String user_email){
		return session.selectOne(namespace +"loginSelect", user_email);
	}
	
	public void logInsert(MemberVO vo){
		session.insert(namespace +"logInsert", vo);
	}
	
	public void moneyUpdate(int member_no){
		session.update(namespace +"moneyUpdate", member_no);
	}
	
	public int logExists(int member_no){
		return session.selectOne(namespace +"logExists", member_no);
	}
}
