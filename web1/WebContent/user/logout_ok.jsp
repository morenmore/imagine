<%@ include file = "/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
session.invalidate();
%>
<script>
alert("정상적으로 로그아웃 되셨습니다.")
location.href = "<%=rootPath%>/user/login.jsp";
</script>