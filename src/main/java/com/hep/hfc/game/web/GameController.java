package com.hep.hfc.game.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/game/*")
public class GameController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(){
		return "redirect:/game/index.do";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index(){
		return "/game/index";
	}
}
