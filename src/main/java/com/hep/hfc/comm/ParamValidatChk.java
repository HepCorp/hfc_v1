package com.hep.hfc.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ParamValidatChk {

	public boolean isNumeric(String param){
		if (param.matches("^[+-]?\\d*(\\.?\\d*)$")){
			return true;
		}
		return false;
	}
	public int toInteger(String param){
		if (param.length() > 10) param = param.substring(0,10);
		if (isNumeric(param)==false) return -1;
		return Integer.parseInt(param);
	}
	public String setLength(String param, int length){
		String result = "";
		if (param.length() > length){
			result = param.substring(0, length);
		} else {
			result = param;
		}
		return result;
	}
	public boolean isEmpty(String param) {
		if (param == null || param.equals("")){
			return true;
		}
		return false;
	}
	public boolean isNull(Object param){
		if (param == null){
			return true;
		}
		return false;
	}
	public String getParam(String param){
		if (isEmpty(param)==false){
			param = param.trim();
			param = Pattern.compile("\\s").matcher(param).replaceAll("");
		}
		return param;
	}
	@SuppressWarnings("unused")
	public boolean isDate(String param){
		Date dt = null;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(param);
			return true;
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public Date toDate(String param, String pattern){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.parse(param);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}
	public boolean isFloat(String param, int num, int dec){
		String regex = "^\\d{1,"+ num +"}(.\\d{"+ dec +"})?$";
		if (param.matches(regex)){
			return true;
		}
		return false;
	}
	public boolean pattern(String gubun, String param){
		String reg;
		
		switch (gubun) {
		case "email": 
			reg = "^[a-zA-Z0-9]+[@][a-zA-Z0-9]+[\\.][a-zA-Z0-9]+$";
			break;
		default :
			reg = "";
			break;
		}

		if (!isEmpty(reg)){
			Boolean result = Pattern.matches(reg, param);
			return result;
		}
		return false;
	}
}
