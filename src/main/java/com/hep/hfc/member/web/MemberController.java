package com.hep.hfc.member.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hep.hfc.member.MemberVO;
import com.hep.hfc.member.service.MemberService;

@Controller
@RequestMapping("/*")
public class MemberController {

	@Autowired
	LoginValidation loginVal;
	
	@Resource(name="memberService")
	MemberService service;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main (){
		return "/index";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(
			  @ModelAttribute("memberVO") MemberVO memberVO
			, BindingResult result
			, HttpSession session
			, HttpServletRequest request
			, ModelMap model){
		loginVal.validate(memberVO, result);
		if (result.hasErrors()) {
			return "/index";
		}
		int count = service.logExists(memberVO.getMember_no());
		memberVO.setIp(request.getRemoteAddr());
		service.logInsert(memberVO);
		if (count == 0){
			service.moneyUpdate(memberVO.getMember_no());
			memberVO.setMoney(memberVO.getMoney()+1);
		}
		System.out.println(memberVO.toString());
		session.setAttribute("memberVO", memberVO);
		
		return "redirect:/";
	}
}
