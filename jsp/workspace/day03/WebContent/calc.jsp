<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정수 입력</title>
</head>
<body>
	<form action="Oper" name="expression-form">
		<input type="text" placeholder="수식 입력" id="expression" name="expression">
		<input type="button" id="send" value="결과 확인">
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$("#send").on("click", () => {
		if(!$("#expression").val()) {
			alert("수식을 입력해주세요.");
			return;
		}
		
		$("form[name='expression-form']").submit();
	})
</script>
</html>