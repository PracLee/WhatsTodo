<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="popTodo" required="true" type="java.util.List"%>
<nav
	class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



	<ul class="navbar-nav ml-auto">

		<!-- Nav Item - Alerts -->
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> 
		</a> <!-- Dropdown - Alerts -->
			<div
				class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="alertsDropdown">
				<h6 class="dropdown-header">what's popular todo?</h6>
				 <!-- 반복 -->
				<c:forEach var="pt" items="${popTodo}" varStatus="st">
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div>
							<div class="small text-gray-500">${pt.todoCnt}peopledoing</div>
							<span class="font-weight-bold">${pt.todo}</span>
						</div>
					</a>
				</c:forEach>
				<a class="dropdown-item text-center small text-gray-500" href="main.do">Return Show My Todos</a>
			</div></li>


		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <span
				class="mr-2 d-lg-inline text-gray-600 small">${ClientData.name}</span>
		</a> <!-- Dropdown - User Information -->
			<div
				class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="clientupdate.jsp"> <i
					class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
				</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="logout.do"> <i
					class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
					Logout
				</a>
			</div></li>

	</ul>

</nav>