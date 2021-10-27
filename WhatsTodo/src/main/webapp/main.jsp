<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
</head>
<body>
	<div class="container">
		<form method="post" action="insertTodo.do">
			<section class="content bgcolor-1">
				<span class="input input--nariko"> <input
					class="input__field input__field--nariko" type="date" id="input-21"
					name="deadLine" /> <label
					class="input__label input__label--nariko" for="input-21"> <span
						class="input__label-content input__label-content--nariko">DeadLine</span>
				</label>
				</span> <span class="devideword">까지</span> <span
					class="input input--nariko"> <input
					class="input__field input__field--nariko" type="text" id="input-22"
					name="todo" /> <label class="input__label input__label--nariko"
					for="input-22"> <span
						class="input__label-content input__label-content--nariko">Todo</span>
				</label>
				</span> <input class="devideword" type="submit" value="할꺼야!">
			</section>
			<input type ="hidden" name="cid" value="${ClientData.id}">
		</form>
		<mytag:datas TodoList="${datas}"/>
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
</body>
</html>
