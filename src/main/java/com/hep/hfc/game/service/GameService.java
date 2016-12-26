package com.hep.hfc.game.service;

import java.util.List;

import com.hep.hfc.game.StageVO;

public interface GameService {
	/**
	 * 스테이지 목록
	 * @param int - 회원번호
	 * @return List<StageVO> - 스테이지 목록 list
	 * @exception Exception
	 */
	public List<StageVO> stageSelectAll(int member_no);

}
