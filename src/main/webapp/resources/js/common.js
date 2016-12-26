/**
 * name : 공통함수
 * filename : common.js
 * Author : ysy
 * Date : 2016-12-23
 */
function pattern(patt, val){
	var regExp;
	switch (patt) {
	case "email":
		regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		break;

	default:
		regExp = "";
		break;
	}
	if (regExp != null && regExp != ""){
		var result = regExp.test(val);
		return result;
	}
	return false;
}

function logout(){
	if(confirm("로그아웃 하시겠습니까?")){
		return true;
	} else {
		return false;
	}
}