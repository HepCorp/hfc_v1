package com.hep.hfc.game.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hep.hfc.comm.ParamValidatChk;
import com.hep.hfc.game.PlayVO;
import com.hep.hfc.game.QnaVO;
import com.hep.hfc.game.service.GameService;

@Component
public class GameValidation extends ParamValidatChk implements Validator {

	@Resource(name="gameService")
	GameService service;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors err) {
		PlayVO inVO = (PlayVO) target;
		
		if (isNull(inVO.getStage_no()) || isNull(inVO.getQna_no())){
			err.rejectValue("qna_no", "field.error.path");
			return;
		}
		if(!isNull(inVO.getPlay_no()) && inVO.getPlay_no() != 0){
			//과거 풀었던 오답 문제가 있었는지 확인.
			int play_no = service.playExistSelect(inVO);
			if (inVO.getPlay_no() != play_no){
				err.rejectValue("play_no", "field.error.path");
				return;
			}
		}
		if(isEmpty(inVO.getUser_answer())){
			err.rejectValue("user_answer", "field.required.user_answer");
			return;
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("qna_no", inVO.getQna_no());
		map.put("member_no", inVO.getMember_no());
		QnaVO qnaVO = service.qnaSelect(map);
		
		if (inVO.getUser_answer().equals(qnaVO.getAnswer())){
			inVO.setAnswer_yn(true);
			inVO.setMoney(0+qnaVO.getMoney());
		} else {
			inVO.setAnswer_yn(false);
			inVO.setMoney(0-qnaVO.getMoney());
		}
	}

	
}
