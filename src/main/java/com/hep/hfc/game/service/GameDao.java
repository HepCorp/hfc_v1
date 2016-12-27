package com.hep.hfc.game.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hep.hfc.game.HintVO;
import com.hep.hfc.game.QnaVO;
import com.hep.hfc.game.StageVO;

@Repository("gameDao")
public class GameDao {
	private String namespace = "gameMapper.";

	@Autowired
	SqlSessionTemplate session;

	public List<StageVO> stageSelectAll(int member_no) {
		return session.selectList(namespace + "stageSelectAll", member_no);
	}

	public QnaVO qnaSelect(HashMap<String, Integer> map) {
		return session.selectOne(namespace + "qnaSelect", map);
	}

	public List<HintVO> hintSelectAll(HashMap<String, Integer> map) {
		return session.selectList(namespace + "hintSelectAll", map);
	}

	public HintVO hintSelect(HashMap<String, Integer> map) {
		return session.selectOne(namespace + "hintSelect", map);
	}

	public void hintLogInsert(HintVO vo) {
		session.insert(namespace + "hintLogInsert", vo);
	}

	public void hintMemberUpdate(HintVO vo) {
		session.update(namespace + "hintMemberUpdate", vo);
	}

}
