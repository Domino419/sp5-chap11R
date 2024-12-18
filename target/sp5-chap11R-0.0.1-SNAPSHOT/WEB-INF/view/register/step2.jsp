<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h2>☆  회원 정보 입력  ☆ </h2>
	<form action="step3" method="post">
		<p>
			<label>이메일 : <br>
			<input type="text" name =  "email" id = "email">
			</label>
		</p>
		<p>
			<label>이름 : <br>
				<input type="text" name =  "name" id = "name">
			</label>
		</p>
		<p>
			<label>비밀번호 : <br>
				<input type="text" name =  "password" id = "password">
			</label>
		</p>
		<p>
			<label>비밀번호 확인 : <br>
				<input type="text" name =  "confirmPassword" id = "confirmPassword">
			</label>
		</p>
	<input type="submit" value="가입 완료">
	</form>
</body>
<script>
	document.querySelector("form").addEventListener("submit", function(event) {
		const email = document.querySelector("#email").value;
		const name = document.querySelector("#name").value;
		const password = document.querySelector("#password").value;
		const confirmPassword = document.querySelector("#confirmPassword").value;

		// 폼 값 출력
		console.log("Email:", email);
		console.log("Name:", name);
		console.log("Password:", password);
		console.log("Confirm Password:", confirmPassword);
	});
</script>
</html>
