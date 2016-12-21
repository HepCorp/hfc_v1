package com.hep.hfc.member.service;

import com.hep.hfc.member.MemberVO;

public interface MemberService {

	/**
	 * 회원정보 가져오
	 * @param int - 회원번호
	 * @return MemberVO
	 * @exception Exception
	 */
	public MemberVO memberSelect(int member_no);

	/**
	 * 로그인 정보 가져오
	 * @param String - 회원이메일
	 * @return MemberVO
	 * @exception Exception
	 */
	public MemberVO loginSelect(String user_email);
}
