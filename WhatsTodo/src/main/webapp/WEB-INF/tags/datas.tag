<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="TodoList" required="true" type="java.util.List"%>

<ul>
	<c:forEach var="tl" items="${TodoList }">
		<li>
		<span>${tl.todo }</span><a href="#">❗</a><a href="#">❌</a>
		</li>
	</c:forEach>
</ul>