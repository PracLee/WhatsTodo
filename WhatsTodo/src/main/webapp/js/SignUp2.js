window.onload = function(){

	function same(input, repeat){
		console.log("input 결과값 : " + input);
		console.log("repeat 결과값 : " + repeat);
		console.log(input==repeat+" : same()의 결과값");
		if(input==repeat){
			document.getElementById("submitBtn").removeAttribute("disabled");
		}	
	}

	// pw 확인 체
	$(document).on('keyup', '#repeatPw', function() {
		console.log("keyperss 작동함");
		var inputPw = $("#inputPw").val();
		var repeatPw = $("#repeatPw").val();
		same(inputPw, repeatPw);
	});

}

//중복체크 로직
function idCheck(){
	var id = $("#inputEmail").val();
	if(id == ""){
		alert('Input ID!');
		return;
	}

	if(!id.includes('@')){
		alert("Input Email Form!");
		return;
	}

	console.log("입력된 id : " + id);
	$.ajax({
		type:"get",
		url:"idCheck.do?id="+id,
		dataType:"json",
		success:function(args){
			var i = args;
			console.log("args = "+args);
			console.log(i);
			if(args==false){				
				console.log("사용할수 있는 ID");
				document.getElementById("inputEmail").setAttribute("readonly", true);
				alert('Usable ID!');
			}else{
				console.log("사용할수 없는 ID");
				alert('Unusable ID!');
			}
		}
	});
}



