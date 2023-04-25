<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board/board.css">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 페이지</h1>
	<hr />
	<ul>
		
	</ul>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	const boards = JSON.parse(`${boards}`);
	const contextPath = `${pageContext.request.contextPath}`;
</script>
<script src="${pageContext.request.contextPath}/static/js/board/list.js"></script>
</html>