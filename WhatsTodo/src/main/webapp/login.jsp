<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- 구글 로그인 OAuth2.0 클라이언트ID -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="1510049929-7vep3930s4noba6qc01vu4ov2ob6sarl.apps.googleusercontent.com">
<title>What's Todo? Login</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">


<!-- google API -->
<script src="https://apis.google.com/js/api:client.js"></script>
<script>
	var googleUser = {};
	var startApp = function() {
		gapi
				.load(
						'auth2',
						function() {
							// Retrieve the singleton for the GoogleAuth library and set up the client.
							auth2 = gapi.auth2
									.init({
										client_id : '1510049929-7vep3930s4noba6qc01vu4ov2ob6sarl.apps.googleusercontent.com',
										cookiepolicy : 'single_host_origin',
									// Request scopes in addition to 'profile' and 'email'
									//scope: 'additional_scope'
									});
							attachSignin(document.getElementById('customBtn'));
						});
	};

	function attachSignin(element) {
		console.log(element.id);
		auth2.attachClickHandler(element, {}, function(googleUser) {
			console.log('googleUser!');
			var profile = googleUser.getBasicProfile();
			var id = profile.getId();
			var pram = "id=" + id;
			$.ajax({
				type : "post",
				url : "googleLogin.do",
				data : pram,
				datatype : "json",
				success:function(args){
	    			if(args){
	    				document.location.href = "main.do";
	    			} else{
	    				alert('There is no registered Google ID. After registering your Google ID, you will be logged in.');
	    				document.location.href = "googleRegister.do";				
	    			} 
	    		}
			});
		}, function(error) {
			alert(JSON.stringify(error, undefined, 2));
		});
	}
</script>
<style type="text/css">
span.buttonText {
	display: inline-block;
	vertical-align: middle;
	font-size: .8rem;
}
</style>
</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									</div>
									<form class="user" action="login.do" method="post">
										<div class="form-group">
											<input type="email" class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												placeholder="Enter Email Address..." name="id">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												id="exampleInputPassword" placeholder="Password" name="pw">
										</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" class="custom-control-input"
													id="customCheck"> <label
													class="custom-control-label" for="customCheck">Remember
													Me</label>
											</div>
										</div>
										<input class="btn btn-primary btn-user btn-block"
											type="submit" value="Login">
										<hr>
										<div id="gSignInWrapper">
											<div id="customBtn"
												class="customGPlusSignIn btn btn-google btn-user btn-block">
												<i class="fab fa-google fa-fw"></i> <span class="buttonText">Google
													Login</span>
											</div>
										</div>
										<!-- FB login button  https 인증서 설치 후 사용가능
										<div class="fb-login-button" data-width="" data-size="large"
											data-button-type="login_with" data-layout="rounded"
											data-auto-logout-link="false" data-use-continue-as="true"></div> -->
									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="register.jsp">Create an Account!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<div></div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>
	<!-- FB login	https 인증서 설치 후 사용가능
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v12.0&appId=184877730496183&autoLogAppEvents=1"
		nonce="ZzTJHbtm"></script>
		 -->
	<!-- 처음 실행하는 함수 -->

	<script>startApp();</script>
</body>

</html>