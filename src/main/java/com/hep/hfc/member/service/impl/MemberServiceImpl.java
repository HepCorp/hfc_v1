package com.hep.hfc.member.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hep.hfc.member.MemberVO;
import com.hep.hfc.member.service.MemberDao;
import com.hep.hfc.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDAO")
	MemberDao dao;
	
	@Override
	public MemberVO memberSelect(int member_no) {
		return dao.memberSelect(member_no);
	}

	@Override
	public MemberVO loginSelect(String user_email) {
		return dao.loginSelect(user_email);
	}

}
