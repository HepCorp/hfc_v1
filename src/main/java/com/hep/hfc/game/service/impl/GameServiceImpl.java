package com.hep.hfc.game.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hep.hfc.game.StageVO;
import com.hep.hfc.game.service.GameService;
import com.hep.hfc.game.service.StageDao;

@Service("gameService")
public class GameServiceImpl implements GameService {

	@Resource(name="stageDao")
	StageDao stage;

	@Override
	public List<StageVO> stageSelectAll(int member_no) {
		return stage.stageSelectAll(member_no);
	}
}
