<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/headerBase.jsp"%>
<c:set var="browserTitle" value="HFC-해커인증시스템" />
<c:set var="menuTitle" value="윷놀이 게임" />
<c:set var="fileName" value="game/index.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/resources/include/header.jsp"%>
<script type="text/javascript" charset="UTF-8" src="/resources/js/game.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/game.css">
<script type="text/javascript">
function FormChkModule(f){
	if ((f.stage_no.value == "" || f.stage_no.value == 0) || 
	    (f.qna_no.value == "" || f.qna_no.value == 0)){
		alert("<spring:message code='field.error.path' />");
		return false;
	}
	if (f.user_answer.value == "") {
		alert("<spring:message code='field.required.user_answer' />");
		f.user_answer.focus();
		return false;
	} 
	if (f.wrong_answer.value == f.user_answer.value) {
		alert("기존과 다른답을 입력해 주세요.");
		f.user_answer.select();
		f.user_answer.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
    <!-- header -->
    <header>
        <div class="navWrap">
            <ul class="nav">
                <li>남은엽전 : ${memberVO.money } 냥</li>
                <li>${memberVO.user_name } 님</li>
                <li><a href="<c:url value="/logout.do" />" title="로그아웃" onclick="return logout();">로그아웃</a></li>
            </ul>
        </div>
    </header>
    <!-- //header -->

    <!-- contents -->
    <section class="contentsWrap">
        <div class="contents">
            <!-- gameWrap(윷놀이판) -->
            <article class="gameWrap">
                <div class="stage">
               	<c:if test="${stageList != null }">
               		<div id="itemStart">START</div>
               	<c:set var="now" value="${0 }" />
               	<c:set var="nowPlay" value="" />
               	<c:set var="nowPlay_no" value="" />
               	<c:forEach items="${stageList }" var="stage">
               		<%-- class 지정 --%>
               		<c:set var="clas" value="smallC" />
               		<c:set var="stat" value="" />
               		<c:choose>         
               			<c:when test="${stage.qna_no == 0 }"><c:set var="stat" value="" /></c:when>
               			<c:when test="${stage.qna_no != 0 && stage.user_answer != null && stage.answer_yn == true }">
	               			<c:if test="${stage.hint_log_cnt > 0 }"><c:set var="stat" value="useHint" /></c:if>
	               			<c:if test="${stage.hint_log_cnt == 0}"><c:set var="stat" value="notUseHint" /></c:if>
               			</c:when>
               			<c:when test="${stage.qna_no != 0 && stage.user_answer != null && stage.answer_yn == false }">
               				<c:set var="stat" value="wrong" />
               			</c:when>
               			<c:when test="${stage.qna_no != 0 && stage.user_answer == null && now == 0 }">
               				<c:set var="stat" value="nowPlay" />
	               			<c:set var="now" value="${now + 1 }" />
	               			<c:set var="nowPlay" value="${stage.stage_nm }" />
	               			<c:set var="nowPlay_no" value="${stage.qna_no }" />
               			</c:when>
               		</c:choose>
               		
               		<c:if test="${fn:startsWith(stage.stage_nm, 'Test')}">
               			<c:set var="clas" value="bigC"></c:set>
               		</c:if>
               		<%-- //class 지정 --%>               		
               		<div id="item${stage.stage_nm }" class="${clas } ${stat }">
	               		<c:if test="${stage.qna_no != 0 }"><a href="" data="${stage.qna_no }">${stage.stage_nm }</a></c:if>
	               		<c:if test="${stage.qna_no == 0 }">${stage.stage_nm }</c:if>
               		</div>
               	</c:forEach>
               	</c:if>
                    <p id="basic"><img src="/resources/images/yut-one.png" alt="윷 한개 이미지">BASIC</p>
                    <p id="system"><img src="/resources/images/yut-one.png" alt="윷 한개 이미지">SYSTEM</p>
                    <p id="network"><img src="/resources/images/yut-one.png" alt="윷 한개 이미지">NETWORK</p>
                    <p id="web"><img src="/resources/images/yut-one.png" alt="윷 한개 이미지">WEB</p>
                </div>
            </article>
            <!-- //gameWrap(윷놀이판) -->

            <!-- categoryBox(범주) -->
            <article class="categoryBox">
                <dl>
                    <dt>1</dt>
                    <dd>: 정답(힌트 미사용)</dd>
                </dl>
                <dl>
                    <dt>2</dt>
                    <dd>: 정답(힌트 사용)</dd>
                </dl>
                <dl>
                    <dt>3</dt>
                    <dd>: 오답</dd>
                </dl>
                <dl>
                    <dt>4</dt>
                    <dd>: 진행중</dd>
                </dl>
            </article>
            <!-- //categoryBox(범주) -->
        </div>
        <!-- startBtn(슬라이드 show/hide 버튼) -->
        <aside class="open" data="${nowPlay_no }">
            ${nowPlay }<br>START
        </aside>
        <!-- //startBtn(슬라이드 show/hide 버튼) -->

        <!-- gameSlide -->
        <article class="gameSlide">
            <section class="game">
                <div class="gameDetail">
                    <h2>ROUND 1-3</h2>
                    <article class="questionBox">
                        <h3>Q</h3>
                        <div id="question">
                            <p>
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry?
                            </p>
                        </div>
                    </article>
	                <article class="fileDown">
	                    <div id="fileBtn">
	                        <div id="downDetail">
	                            <span>attach.txt</span>
	                            <label for="download">
	                                <input type="button" name="download" id="download" value="Download">
	                            </label>
	                        </div>
	                    </div>
	                </article>
                    <article class="hintBox"></article>
                    <article class="answerBox">
                        <h3>A</h3>
                        <form name="saveFrm" method="post" action="<c:url value='/game/save.do' />" class="form" onSubmit="return FormChkModule(this);">
                        <fieldset>
                        <legend>답 제출</legend>
                        	<input type="hidden" id="play_no" name="play_no" value="" />
                        	<input type="hidden" id="stage_no" name="stage_no" value="" />
                        	<input type="hidden" id="qna_no" name="qna_no" value="" />
                        	<input type="hidden" id="wrong_answer" name="wrong_answer" value="" />
                        	<form:errors path="playVO.play_no" cssClass="msgAlert" cssStyle="display:none;" />
                        	<form:errors path="playVO.qna_no" cssClass="msgAlert" cssStyle="display:none;" />
                            <label for="answer">
                                <input type="text" name="user_answer" id="answer" maxlength="30" />
                                <form:errors path="playVO.user_answer" cssClass="msgAlert" cssStyle="display:none;" />
                            </label>
                            <label for="send">
                                <input type="submit" name="send" id="send" value="답 제출" />
                            </label>
                        </fieldset>
                        </form>
                    </article>

                </div>
            </section>
        </article>
        <!-- //gameSlide -->
    </section>
    <!-- //contents -->
</body>
</html>
