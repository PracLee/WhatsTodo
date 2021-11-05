<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>Error!</title>
</head>
<body>
	<div>
		status : <span th:text="${status}"></span>
	</div>
	<div>
		path : <span th:text="${path}"></span>
	</div>
	<div>
		error : <span th:text="${error}"></span>
	</div>
	<div>
		timestamp : <span th:text="${timestamp}"></span>
	</div>
	<div>
		message : <span th:text="${message}"></span>
	</div>
	<div>
		exception : <span th:text="${exception}"></span>
	</div>
	<div>
		trace : <span th:text="${trace}"></span>
	</div>
</body>
</html>