$(function(){
	$(".msgAlert").each(function(){
		alert($(this).text());
		$("input:first").focus();
	});
	$("aside").click(function(){
		var display = $(".gameSlide").css("display");
		if (display == "none") {
			openGame($(this).attr("data"));
		} else {
			closeGame();
		}
	});
	
	$("[id^=item] a").click(function(){
		openGame($(this).attr("data"));
		return false;
	});
});

function openGame(qna_no){
	$(".gameSlide").show();
	$.ajax({
		url: "/game/view.do",
		method: "POST",
		data: {"no":qna_no},
		dataType: "json",
		success : function(qnaData){
			success(qnaData);
		},
		error : function(){alert("실패했습니다.") },
	});
	
	$("aside").animate({"right":"+=503"});
	$(".game").animate({"right":"+=503"}, function(){
		toggleText();
		$("aside").removeClass("open");
		$("aside").addClass("close");
	});
}
function closeGame(){
	$("aside").animate({"right":"-=503"});
	$(".game").animate({"right":"-=503"}, function(){
		toggleText();
		$(".gameSlide").hide();
		$("aside").removeClass("close");
		$("aside").addClass("open");
	});
}

var asideHtml = "";
function toggleText(){
	if (asideHtml == ""){
		asideHtml = $("aside").html();
		$("aside").html("닫기");
	} else {
		$("aside").html(asideHtml);
		asideHtml = "";
	}
}

function success(data){
	$(".gameDetail h2").text("ROUND "+ data.qna.stage_nm);
	$("#play_no").attr("value", data.qna.play_no);
	$("#stage_no").attr("value", data.qna.stage_no);
	$("#qna_no").attr("value", data.qna.qna_no);
	$("#question p").text(data.qna.question);
	$("#answer").val(data.qna.user_answer);
	if (data.qna.answer_yn == true) { //정답이면 문제 풀수 없음.
		$("#answer").attr("disabled", "disabled");
		$("#send").hide();
	} else { //false or null 문제 풀수 있음
		if (data.qna.answer_yn == false) { //오답이면 문제 다시 풀기.
			$("#wrong_answer").val(data.qna.user_answer);
			$("#answer").select();
			$("#answer").focus();
		}
		$("#answer").removeAttr("disabled");
		$("#send").show();
	}
	$("#downDetail span").text(data.qna.attach_file);
	if (data.qna.attach_type == 'F'){
		$("#download").val("Download");
		$("#download").click(function(){
	        location.href="/game/downloadFile.do?file="+ data.qna.attach_file;
		});
	} else {
		$("#download").val("Click");
		$("#download").click(function(){
			window.open("/resources/download/"+ data.qna.attach_file);
		})
	}
	var hintHtml = "";
	if (data.hint.length == 0){
		$(".hintBox").hide();
	} else {
		$(".hintBox").show();
	}
	for (var i=0;i<data.hint.length;i++){
		hintHtml += "<div class='hintWrap'>";
		if (data.hint[i].log_no == 0) {
			hintHtml += "<label for='hintBtn0"+ data.hint[i].seq +"'>";
			hintHtml += "    <input type='button' data='"+ data.hint[i].hint_no +"' id='hintBtn0"+ data.hint[i].seq +"' value='힌트"+ data.hint[i].seq +" 사용 "+ data.hint[i].money +"냥 CLICK!'>";
			hintHtml += "</label>";
			hintHtml += "<div id='hint0"+ data.hint[i].seq +"' style='display:none;'></div>"
		} else {
			hintHtml += "<label for='hintBtn0"+ data.hint[i].seq +"'>";
			hintHtml += "    <input type='button' id='hintBtn0"+ data.hint[i].seq +"' value='힌트"+ data.hint[i].seq +"' disabled='disabled'>";
			hintHtml += "</label>";
			hintHtml += "<div id='hint0"+ data.hint[i].seq +"'>"
			hintHtml += "    <p>"+ data.hint[i].seq +". "+ data.hint[i].hint +"</p>"
			hintHtml += "</div>"			
		}
		hintHtml += "</div>";
	}
	$(".hintBox").html(hintHtml);
	console.log(data.qna.answer_yn);
	if (data.qna.answer_yn == false || data.qna.answer_yn == null) {
		$(".hintBox input[type='button']").click(function(){
			var hint_no = $(this).attr("data");
			if (confirm("힌트를 확인하시겠습니까? 해당 금액이 차감됩니다.")){
				hintUse(hint_no);
			}
		});
	} else {
		$(".hintBox input[type='button']").click(function(){
			alert("이미 푼 문제의 힌트는 확인할 수 없습니다.");
			return false;
		});
	}
}

function hintUse(hint_no){
	$.ajax({
		url: "/game/hintView.do",
		method: "POST",
		data: {"no":hint_no},
		dataType: "json",
		success : function(hintData){
			if (hintData == null){
				alert("이미 사용하였거나, 존재하지 않습니다.");
				return false;
			} else {
				var hintHtml = "<p>"+ hintData.seq +". "+ hintData.hint +"</p>";
				var input = $("#hintBtn0"+ hintData.seq);
				var obj = $("#hint0"+ hintData.seq);
				input.attr("disabled", "disabled");
				input.val("힌트"+ hintData.seq);
				obj.html(hintHtml);
				obj.show();
			}
		},
		error : function(){alert("실패했습니다.") },
	});
}