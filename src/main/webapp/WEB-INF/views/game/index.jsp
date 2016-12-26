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
                <li><a href="<c:url value="/logout.do" />" title="로그아웃" >로그아웃</a></li>
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
                    <div id="itemStart" class="bigC"><a href="">START</a></div>
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
                    <div id="item8-2" class="smallC"><a href="">8-2</a></div>
                    <p id="basic">BASIC</p>
                    <p id="system">SYSTEM</p>
                    <p id="network">NETWORK</p>
                    <p id="web">WEB</p>
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
        <aside class="startBtn">
            <a href="">1-1<br>START</a>
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
                            <span>
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry?
                            </span>
                        </div>
                    </article>
                    <article class="hintBox">
                        <form>
                            <input type="button" id="hintBtn01" value="힌트1 사용 3냥 CLICK!">
                        </form>
                        <div id="hint01">
                            <p>1. Vivamus luctus lectus quis molestie pretium.</p>
                        </div>
                        <form>
                            <input type="button" id="hintBtn02" value="힌트2 사용 3냥 CLICK!">
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
                        </form>
                    </article>
                </div>
                <article class="fileDown">
                    <p>attach.txt</p>
                    <a href="">Download</a>
                </article>
            </section>
        </article>
        <!-- //gameSlide -->
    </section>
    <!-- //contents -->
</body>
</html>