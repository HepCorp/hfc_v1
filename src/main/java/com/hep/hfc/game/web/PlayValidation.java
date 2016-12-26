package com.hep.hfc.game.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hep.hfc.comm.ParamValidatChk;

@Component
public class PlayValidation extends ParamValidatChk implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors err) {
		
	}

	
}
