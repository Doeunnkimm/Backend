<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>목록</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board/board.css">
</head>
<body>
    <main id="board">
    	<jsp:include page="../fix/header.jsp"/>
        <section id="board-banner">
            <div><a href="javascript:location.href='${pageContext.request.contextPath}/board/write.board'"><img src="${pageContext.request.contextPath}/static/images/board_banner.png"></a></div>
        </section>
        <section id="info-wrap">
            <article id="info-container">
                <h6 class="info">게시글 목록<br>개</h6>
                <section class="order">
                    <a>최신순</a>
                    <a>인기순</a>
                </section>
            </article>
            <section id="content-wrap">
                <ul></ul>
                <div id="paging-wrap">
                </div>
            </section>
        </section>
    </main>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/board/board.js"></script>
<script>
	let boards = JSON.parse(`${boards}`);
	console.log(boards);
</script>
</html>
















