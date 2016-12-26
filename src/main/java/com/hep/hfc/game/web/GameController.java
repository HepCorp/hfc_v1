package com.hep.hfc.game.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hep.hfc.game.service.GameService;
import com.hep.hfc.member.MemberVO;

@Controller
@RequestMapping("/game/*")
public class GameController {

	@Resource(name="gameService")
	GameService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(){
		return "redirect:/game/index.do";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model){
		int member_no = getMember_no(session);
		
		model.addAttribute("stageList", service.stageSelectAll(member_no));
		return "/game/index";
	}
	
	private int getMember_no(HttpSession session){
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		return memberVO.getMember_no();
	}
}
