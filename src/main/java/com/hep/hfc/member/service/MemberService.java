package com.hep.hfc.member.service;

import com.hep.hfc.member.MemberVO;

public interface MemberService {

	/**
	 * 로그인 정보 가져오
	 * @param String - 회원이메일
	 * @return MemberVO
	 * @exception Exception
	 */
	public MemberVO loginSelect(String user_email);
	
	/**
	 * 로그인시 로그 저장
	 * @param VO - 회원정보가 담긴 MemberVO
	 * @return void
	 * @exception Exception
	 */
	public void logInsert(MemberVO vo);
	
	/**
	 * 로그인시 머니 추가
	 * @param Integer - 회원번호 member_no
	 * @return void
	 * @exception Exception
	 */
	public void moneyUpdate(int member_no);
	
	/**
	 * 당일 로그인로그수 카운
	 * @param Integer - 회원번호 member_no
	 * @return int
	 * @exception Exception
	 */
	public int logExists(int member_no);
}
