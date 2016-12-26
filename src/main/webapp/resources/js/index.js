$(function(){
	$(".msgAlert").each(function(){
		alert($(this).text());
		$("input:first").focus();
	});
});