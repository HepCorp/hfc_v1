<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
response.setHeader("Pragma", "No-cache"); //HTTP1.0
response.setHeader("Cache-Control", "no-cache"); //HTTP1.1
response.addHeader("Cache-Control", "no-store"); //Chrome, FireFox Browser...

response.setDateHeader("Expires", 1L);
%>