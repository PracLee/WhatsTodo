
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
				document.getElementById("submitBtn").removeAttribute("disabled");
				alert('Usable ID!');
			}else{
				console.log("사용할수 없는 ID");
				alert('Unusable ID!');
			}
		}
	});
}


