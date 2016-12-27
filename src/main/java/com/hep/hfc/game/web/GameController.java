package com.hep.hfc.game.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hep.hfc.game.HintVO;
import com.hep.hfc.game.QnaVO;
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
	
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	private @ResponseBody HashMap<String, Object> qnaView(
			  @RequestParam(value="no", required=true) int qna_no
			, HttpSession session){
		int member_no = getMember_no(session);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_no", member_no);
		map.put("qna_no", qna_no);
		
		HashMap<String, Object> voMap = new HashMap<String, Object>();
		QnaVO qnaVO = service.qnaSelect(map);
		List<HintVO> hintList = service.hintSelectAll(map);
		voMap.put("qna", qnaVO);
		voMap.put("hint", hintList);
		
		return voMap;
	}
	
	@RequestMapping(value="/hintView.do", method=RequestMethod.GET)
	private @ResponseBody HintVO hintView(
			  @RequestParam(value="no", required=true) int hint_no
			, HttpSession session
			, HttpServletRequest request){
		MemberVO member = (MemberVO) session.getAttribute("memberVO");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_no", member.getMember_no());
		map.put("hint_no", hint_no);
		
		HintVO hint = service.hintSelect(map);
		hint.setIp(request.getRemoteAddr());
		hint.setMember_no(member.getMember_no());
		
		if (member.getMoney() > hint.getMoney()){
			//세션 머니 차감
			member.setMoney(member.getMember_no() - hint.getMoney());
			member.setIp(request.getRemoteAddr());
			session.setAttribute("memberVO", member);
			//로그 저장
			service.hintLogInsert(hint);
			//멤버테이블 머니 차감
			service.hintMemberUpdate(hint);
		} else {
			return null;
		}
		return hint;
	}
	
	@RequestMapping(value="/downloadFile.do")
	public void downloadFile(
			  @RequestParam(value="file", required=true) String attach_file
			, HttpServletResponse response
			, HttpServletRequest request) throws Exception{
	    String dataDirectory = request.getSession().getServletContext().getRealPath("/resources/download/");
	    Path file = Paths.get(dataDirectory, attach_file);
	    
	    if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+attach_file);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
}
