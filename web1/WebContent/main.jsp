<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>IOT MAIN</title>

</head>

<body class='mainbody'>

	<jsp:include page="/common/top.jsp" flush="fasle">
		<jsp:param value="<%=login%>" name="login" />
	</jsp:include>
	<div class="container">
		<div class="starter-template">
			<h1>메인화면</h1>
			<p>환영합니다</p>
		</div>
	</div>
</body>
</html>