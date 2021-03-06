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

<style type="text/css">
@import
url("css/signUp.css")
</style>
<title>SB Admin 2 - Register</title>

<!-- 유효성검사 -->
<script src="js/SignUp2.js"></script>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/nomalize.css" rel="stylesheet">
<!-- google API -->
<script src="https://apis.google.com/js/api:client.js"></script>
<script>
  var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '1510049929-7vep3930s4noba6qc01vu4ov2ob6sarl.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('customBtn'));
    });
  };

  function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
    	console.log('googleUser!');
    	var profile = googleUser.getBasicProfile();
    	var id = profile.getId();
    	var name = profile.getName();
    	var pram = "id="+ id + "&name=" + name;
    	$.ajax({
    		type:"post",
    		url:"googleRegister.do",
    		data:pram,
    		datatype:"json",
    		success:function(args){
    			console.log("googleUser args : " + args);
    			if(args){
    				alert('Already exist Google id!');
    				document.location.href = "index.jsp";
    			} else{
    				document.location.href = "main.do";				
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

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">JoinUs What's Todo</h1>
							</div>
							<form class="user" method="post" action="insertClient.do">
								<div class="form-group">
									<input type="email"
										class="form-control form-control-user check" id="inputEmail"
										placeholder="Email Address" name="id" required="required">
									<a type="button" href="javascript:void(0);" onclick="idCheck()"
										class="btn btn-user btn-block" id="checkID"> ID Check </a>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text"
											class="form-control form-control-user check" id="inputName"
											placeholder="Name" name="name" required="required">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password"
											class="form-control form-control-user check" id="inputPw"
											placeholder="Password" name="pw" required="required">
									</div>
									<div class="col-sm-6">
										<input type="password"
											class="form-control form-control-user check" id="repeatPw"
											placeholder="Repeat Password" required="required">
									</div>
								</div>
								<input type="submit" class="btn btn-primary btn-user btn-block"
									disabled="disabled" value="Register Account" id="submitBtn">
								<hr>
								<div id="gSignInWrapper">
									<div id="customBtn"
										class="customGPlusSignIn btn btn-google btn-user btn-block">
										<i class="fab fa-google fa-fw" ></i>
										<span class="buttonText">Google
											Register</span>
									</div>
								</div>
							</form>
							<hr>
							<div class="text-center">
								<a class="small" href="login.jsp">Already have an account?
									Login!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<script>startApp();</script>
</body>

</html>