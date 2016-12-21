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
	
	public MemberVO memberSelect(int member_no){
		return session.selectOne(namespace + "memberSelect", member_no);
	}
	
	public MemberVO loginSelect(String user_email){
		return session.selectOne(namespace +"loginSelect", user_email);
	}
}
