$(function(){
	$(".msgAlert").each(function(){
		alert($(this).text());
		$("input:first").focus();
	});
	$("#email").css("ime-mode", "disabled");
	$("#email").attr("pattern", "[A-Za-z0-9@.]*")
});
