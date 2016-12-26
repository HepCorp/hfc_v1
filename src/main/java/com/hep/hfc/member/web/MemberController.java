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
		return "redirect:/index.do";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index(){
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
		memberVO.setIp(request.getRemoteAddr());
		
		//하루에 한번만 적립
		int count = service.logExists(memberVO.getMember_no());
		if (count == 0){
			service.logInsert(memberVO);
			service.moneyUpdate(memberVO.getMember_no());
			memberVO.setMoney(memberVO.getMoney()+1);
		}
		session.setAttribute("memberVO", memberVO);
		
		return "redirect:/game/index.do";
	}
}
