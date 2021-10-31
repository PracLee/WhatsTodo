<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>what's todo main</title>
<meta name="description"
	content="Simple ideas for enhancing text input interactions" />
<meta name="keywords"
	content="input, text, effect, focus, transition, interaction, inspiration, web design" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/set2.css" />
<!-- notinputTemplate -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
</head>
<body>
	<div class="container">
		<mytag:topbar popTodo="${popTodo}"/>
		<form method="post" action="insertTodo.do">
			<section class="content bgcolor-1">
				<span class="input input--nariko"> <input
					class="input__field input__field--nariko" type="date" id="input-21" min="${today}"
					name="deadLine" required="required" /> <label
					class="input__label input__label--nariko" for="input-21"> <span
						class="input__label-content input__label-content--nariko">DeadLine</span>
				</label>
				</span> <span class="devideword"><spring:message code="message.main.to"/></span> <span
					class="input input--nariko"> <input
					class="input__field input__field--nariko" type="text" id="input-22" required="required"
					name="todo" /> <label class="input__label input__label--nariko"
					for="input-22"> <span
						class="input__label-content input__label-content--nariko">Todo</span>
				</label>
				</span> <input class="devideword" type="submit" value="<spring:message code="message.main.doit" />">
			</section>
			<input type="hidden" name="cid" value="${ClientData.id}">
		</form>

		<!-- 목록 출력 -->
		<div class="col-sm-12">
			<table class="table table-bordered dataTable">
				<tr>
					<th><spring:message code="message.main.deadLine" /></th>
					<th><spring:message code="message.main.todo" /></th>
					<th><spring:message code="message.main.update" /></th>
					<th><spring:message code="message.main.delete" /></th>
					<th><spring:message code="message.main.achieve" /></th>
				</tr>
				<c:forEach var="tl" items="${TodoDatas}">
					<tr id="todoSet_${tl.todoNum}">
						<td>${tl.deadLine}</td>
						<td><span id="text_${tl.todoNum}">${tl.todo}</span><input type="text" id="input_${tl.todoNum}" class="noShow">
						<a href="javascript:void(0);" onclick="editCancle(${tl.todoNum})" id="cancleButton_${tl.todoNum}" class="noShow">❌</a>
						</td>
						<td>
						<!-- show input button -->
						<a href="javascript:void(0);" onclick="showInput(${tl.todoNum})" id="showInputButton_${tl.todoNum}">❗</a>
						<!-- updateDB button -->
						<a href="javascript:void(0);" onclick="todoEditDB(${tl.todoNum})" id="updateButton_${tl.todoNum}" class="noShow">❗</a>
						</td>
						<td><a href="javascript:void(0);" onclick="deleteTodoDB(${tl.todoNum})" id="deleteTodoButton_${tl.todoNum}">❌</a></td>
						<td><a href="javascript:void(0);" onclick="todoAchieve(${tl.todoNum})" id="achieveTodoButton_${tl.todoNum}">⭕</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- /container -->
	<script src="js/classie.js"></script>
	<script>
		(function() {
			if (!String.prototype.trim) {
				(function() {
					var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
					String.prototype.trim = function() {
						return this.replace(rtrim, '');
					};
				})();
			}

			[].slice.call(document.querySelectorAll('input.input__field'))
					.forEach(function(inputEl) {
						if (inputEl.value.trim() !== '') {
							classie.add(inputEl.parentNode, 'input--filled');
						}

						inputEl.addEventListener('focus', onInputFocus);
						inputEl.addEventListener('blur', onInputBlur);
					});

			function onInputFocus(ev) {
				classie.add(ev.target.parentNode, 'input--filled');
			}

			function onInputBlur(ev) {
				if (ev.target.value.trim() === '') {
					classie.remove(ev.target.parentNode, 'input--filled');
				}
			}
		})();
	</script>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
</body>
</html>
