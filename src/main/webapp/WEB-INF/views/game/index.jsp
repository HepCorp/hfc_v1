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
               		<div id="itemStart" class="bigC"><a href="">START</a></div>
               	<c:set var="now" value="${0 }" />
               	<c:set var="nowPlay" value="" />
               	<c:forEach items="${stageList }" var="stage">
               		<!-- class 지정 -->
               		<c:set var="clas" value="smallC" />
               		<c:set var="stat" value="" />
               		<c:choose>
               			<c:when test="${stage.qna_no == 0 }"><c:set var="stat" value="" /></c:when>
               			<c:when test="${stage.qna_no != 0 && stage.answer_yn == true }">
	               			<c:if test="${stage.hint_log_cnt > 0 }"><c:set var="stat" value="useHint" /></c:if>
	               			<c:if test="${stage.hint_log_cnt == 0}"><c:set var="stat" value="notUseHint" /></c:if>
               			</c:when>
               			<c:when test="${stage.qna_no != 0 && stage.answer_yn == false && now == 0 }">
               				<c:set var="stat" value="nowPlay" />
	               			<c:set var="now" value="${now + 1 }" />
	               			<c:set var="nowPlay" value="${stage.stage_nm }" />
               			</c:when>
               		</c:choose>
               		
               		<c:if test="${fn:startsWith(stage.stage_nm, 'Test')}">
               			<c:set var="clas" value="bigC"></c:set>
               		</c:if>
               		<!-- //class 지정 -->
               		
               		<div id="item${stage.stage_nm }" class="${clas } ${stat }">
               		<c:if test="${stage.qna_no != 0 }">
               			<a href="">${stage.stage_nm }</a>
               		</c:if>
               		<c:if test="${stage.qna_no == 0 }">
               			${stage.stage_nm }
               		</c:if>	
               		</div>
               	</c:forEach>
               	</c:if>
                    <!-- <div id="itemStart" class="bigC"><a href="">START</a></div>
                    <div id="item1-1" class="smallC"><a href="">1-1</a></div>
                    <div id="item1-2" class="smallC"><a href="">1-2</a></div>
                    <div id="item1-3" class="smallC"><a href="">1-3</a></div>
                    <div id="item1-4" class="smallC"><a href="">1-4</a></div>
                    <div id="itemTest1" class="bigC"><a href="">TEST1</a></div>
                    <div id="item2-1" class="smallC"><a href="">2-1</a></div>
                    <div id="item2-2" class="smallC"><a href="">2-2</a></div>
                    <div id="item2-3" class="smallC"><a href="">2-3</a></div>
                    <div id="item2-4" class="smallC"><a href="">2-4</a></div>
                    <div id="itemTest2" class="bigC"><a href="">TEST2</a></div>
                    <div id="item3-1" class="smallC"><a href="">3-1</a></div>
                    <div id="item3-2" class="smallC"><a href="">3-2</a></div>
                    <div id="item3-3" class="smallC"><a href="">3-3</a></div>
                    <div id="item3-4" class="smallC"><a href="">3-4</a></div>
                    <div id="itemTest3" class="bigC"><a href="">TEST3</a></div>
                    <div id="item4-1" class="smallC"><a href="">4-1</a></div>
                    <div id="item4-2" class="smallC"><a href="">4-2</a></div>
                    <div id="item4-3" class="smallC"><a href="">4-3</a></div>
                    <div id="item4-4" class="smallC"><a href="">4-4</a></div>
                    <div id="itemTest4" class="bigC"><a href="">TEST4</a></div>
                    <div id="item5-1" class="smallC"><a href="">5-1</a></div>
                    <div id="item5-2" class="smallC"><a href="">5-2</a></div>
                    <div id="item6-1" class="smallC"><a href="">6-1</a></div>
                    <div id="item6-2" class="smallC"><a href="">6-2</a></div>
                    <div id="item7-1" class="smallC"><a href="">7-1</a></div>
                    <div id="item7-2" class="smallC"><a href="">7-2</a></div>
                    <div id="item8-1" class="smallC"><a href="">8-1</a></div>
                    <div id="item8-2" class="smallC"><a href="">8-2</a></div> -->
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
        <aside>
            <a href="">${nowPlay }<br>START</a>
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
                    <article class="hintBox">
                        <form>
                            <fieldset>
                                <legend>힌트 버튼 1</legend>
                                <label for="hintBtn01">
                                    <input type="button" id="hintBtn01" value="힌트1 사용 3냥 CLICK!">
                                </label>
                            </fieldset>
                        </form>
                        <div id="hint01">
                            <p>1. Vivamus luctus lectus quis molestie pretium.</p>
                        </div>
                        <form>
                            <fieldset>
                                <legend>힌트 버튼 2</legend>
                                <label for="hintBtn02">
                                    <input type="button" id="hintBtn02" value="힌트2 사용 3냥 CLICK!">
                                </label>
                            </fieldset>
                        </form>
                        <div id="hint02">
                            <p>2. Donec dignissim libero et ex laoreet auctor.</p>
                        </div>
                    </article>
                    <article class="answerBox">
                        <h3>A</h3>
                        <form>
                            <fieldset>
                                <legend>답</legend>
                                <label for="answer">
                                    <textarea name="answer" id="answer" cols="30" rows="3"></textarea>
                                </label>
                            </fieldset>
                            <fieldset>
                                <legend>답 제출</legend>
                                <label for="send">
                                    <input type="submit" name="send" id="send" value="답 제출" onclick="">
                                </label>
                            </fieldset>
                        </form>
                    </article>

                </div>
                <article class="fileDown">
                    <div id="fileBtn">
                        <div id="downDetail">
                            <span>attach.txt</span>
                            <form>
                                <fieldset>
                                    <legend>파일 다운로드</legend>
                                    <label for="download">
                                        <input type="button" name="download" id="download" value="Download">
                                    </label>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </article>
            </section>
        </article>
        <!-- //gameSlide -->
    </section>
    <!-- //contents -->
</body>
</html>