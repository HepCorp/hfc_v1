package com.hep.hfc.game.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hep.hfc.game.StageVO;

@Repository("stageDao")
public class StageDao {
	
	private String namespace = "gameMapper.";
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<StageVO> stageSelectAll(int member_no){
		return session.selectList(namespace +"stageSelectAll", member_no);
	}
}
