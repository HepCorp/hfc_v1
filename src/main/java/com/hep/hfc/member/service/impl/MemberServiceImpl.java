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
	public MemberVO loginSelect(String user_email) {
		return dao.loginSelect(user_email);
	}

	@Override
	public void logInsert(MemberVO vo) {
		dao.logInsert(vo);
		
	}

	@Override
	public void moneyUpdate(int member_no) {
		dao.moneyUpdate(member_no);
	}

	@Override
	public int logExists(int member_no) {
		return dao.logExists(member_no);
	}

}
