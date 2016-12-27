package com.hep.hfc.game.service;

import java.util.HashMap;
import java.util.List;

import com.hep.hfc.game.HintVO;
import com.hep.hfc.game.QnaVO;
import com.hep.hfc.game.StageVO;

public interface GameService {
	/**
	 * 스테이지 목록
	 * @param int - 회원번호
	 * @return List<StageVO> - 스테이지 목록 list
	 * @exception Exception
	 */
	public List<StageVO> stageSelectAll(int member_no);
	
	/**
	 * 문제 불러오기
	 * @param HashMap<String, Integer> - 문제번호, 회원번
	 * @return QnaVO - 문제상세
	 * @exception Exception
	 */
	public QnaVO qnaSelect(HashMap<String, Integer> map);

	public List<HintVO> hintSelectAll(HashMap<String, Integer> map);
	
	public HintVO hintSelect(HashMap<String, Integer> map);
	
	public void hintLogInsert(HintVO vo);
	
	public void hintMemberUpdate(HintVO vo);

}
