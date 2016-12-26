<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/headerBase.jsp"%>
<c:set var="browserTitle" value="HFC-해커인증시스템" />
<c:set var="menuTitle" value="로그인" />
<c:set var="fileName" value="index.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/resources/include/header.jsp"%>
<script type="text/javascript" charset="UTF-8" src="/resources/js/index.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/index.css">
<script type="text/javascript">
function FormChkModule(f){
	if (f.user_email.value == ""){
		alert("<spring:message code='field.required.email' />");
		f.user_email.focus();
		return false;
	} else {
		if (!pattern("email", f.user_email.value)){
			alert("<spring:message code='field.error.pattern.email' />");
			f.user_email.select();
			f.user_email.focus();
			return false;
		}
	}
 	if (f.user_pwd.value == ""){
		alert("<spring:message code='field.required.password' />");
		f.user_pwd.focus();
		return false;
	}
	return true;	
}
</script>
</head>
<body>${memberVO.user_name }
    <section class="contentsWrap">
        <div class="contents">
            <div class="loginWrap">
                <div class="hfc_logo">
                    <img src="/resources/images/hfc_logo_bk.png" alt="에이치에프씨 로고 검정">
                </div>
                <form name="saveFrm" method="post" action="<c:url value='/login.do' />" class="form" onSubmit="return FormChkModule(this);">
                    <fieldset>
                        <legend>로그인</legend>
                        <label for="email">
                            <input type="email" name="user_email" id="email" placeholder="이메일" />
                            <form:errors path="memberVO.user_email" cssClass="msgAlert" cssStyle="display:none;" />
                        </label>
                        <label for="passwd">
                            <input type="password" name="user_pwd" id="passwd" placeholder="비밀번호" />
                            <form:errors path="memberVO.user_pwd" cssClass="msgAlert" cssStyle="display:none;" />
                        </label>
                        <input type="submit" value="Log In" />
                    </fieldset>
                </form>
            </div>
            <div class="textWrap">
                <img src="/resources/images/yut-four.png" alt="윷 네개 이미지">
                <p>Let the Game begin...</p>
            </div>
        </div>
    </section>
    <footer>
        <div class="footerWrap">
            <img src="/resources/images/yut-one.png" alt="윷 한개 이미지">
            <p>Copyright 2016. HEP Corp. All rights reserved.</p>
        </div>
    </footer>
</html>
