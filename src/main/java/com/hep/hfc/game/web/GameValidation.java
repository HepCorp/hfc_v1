package com.hep.hfc.game.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hep.hfc.comm.ParamValidatChk;
import com.hep.hfc.game.PlayVO;
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
		
		
	}

	
}
