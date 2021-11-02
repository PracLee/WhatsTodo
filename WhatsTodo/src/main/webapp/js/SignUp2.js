
function idCheck(){
	var id = $("#inputEmail").val();
	if(id == ""){
		alert('Input ID!');
		return;
	}
	console.log("입력된 id" + id);
	$.ajax({
		type:"get",
		url:"idCheck.do?id="+id,
		dataType:"json",
		success:function(args){
			console.log("arg가 뭔데" + args);
		}
	});
}

