package com.hep.hfc.game.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hep.hfc.game.HintVO;
import com.hep.hfc.game.QnaVO;
import com.hep.hfc.game.StageVO;
import com.hep.hfc.game.service.GameDao;
import com.hep.hfc.game.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService {

	@Resource(name="gameDao")
	GameDao dao;

	@Override
	public List<StageVO> stageSelectAll(int member_no) {
		return dao.stageSelectAll(member_no);
	}
	
	@Override
	public QnaVO qnaSelect(HashMap<String, Integer> map) {
		return dao.qnaSelect(map);
	}

	@Override
	public List<HintVO> hintSelectAll(HashMap<String, Integer> map) {
		return dao.hintSelectAll(map);
	}

	@Override
	public HintVO hintSelect(HashMap<String, Integer> map) {
		return dao.hintSelect(map);
	}

	@Override
	public void hintLogInsert(HintVO vo) {
		dao.hintLogInsert(vo);
	}

	@Override
	public void hintMemberUpdate(HintVO vo) {
		dao.hintMemberUpdate(vo);
	}

}
