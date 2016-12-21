package com.hep.hfc.member.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hep.hfc.comm.ParamValidatChk;
import com.hep.hfc.member.MemberVO;
import com.hep.hfc.member.service.MemberService;

@Component
public class LoginValidation extends ParamValidatChk implements Validator {

	@Resource(name="MemberService")
	MemberService service;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors err) {
		MemberVO inVO = (MemberVO) target;

		String input_email;
		String input_pwd;
		
		if (isNull(inVO)){
			input_email = "";
			input_pwd = "";
		} else {
			input_email = getParam(inVO.getUser_email());
			input_pwd = getParam(inVO.getUser_pwd());
		}
		if (isEmpty(input_email)){
			err.rejectValue("user_email", "이메일을 입력해 주세요.");
		}
		if (isEmpty(input_pwd)){
			err.rejectValue("user_pwd", "비밀번호를 입력해 주세요.");
		}
		
		MemberVO outVO = service.loginSelect(input_email);
		if (isNull(outVO)){
			err.rejectValue("user_email", "이메일을 잘못 입력하셨습니다.");
		} else {
			outVO.setUser_email(input_email);
			int member_no = outVO.getMember_no();
			String user_pwd = outVO.getUser_pwd();
			
			if (isNull(member_no) || member_no == 0 || isEmpty(user_pwd)){
				err.rejectValue("user_email", "이메일을 잘못 입력하셨습니다.");
			} else {
				if (input_pwd != user_pwd){
					err.rejectValue("user_pwd", "비밀번호를 잘못 입력하셨습니다.");
				}
			}
		}
	}
}

