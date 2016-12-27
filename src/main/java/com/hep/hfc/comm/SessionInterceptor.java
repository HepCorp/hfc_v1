package com.hep.hfc.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hep.hfc.member.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//임시로그인
		//request.getSession().setAttribute("memberVO", new MemberVO(1, "윤수연", "test@greatkorea.co", "123456", 12, "", null, null));
		StringBuffer mainPage = request.getRequestURL();
		MemberVO member = (MemberVO) request.getSession().getAttribute("memberVO");
		Boolean game = mainPage.toString().contains("/game/");
		
		if (game) {
			if (member == null){
				response.sendRedirect(request.getContextPath() +"/index.do");
				return false;
			} 
		}
		return true;
	}
}
