<%@ page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<style>
#box{
	width:200px;
	height:150px;
	background:yellow;	
}
</style>
<script>
	window.addEventListener("load",function(){
		//문서내의 버튼에 이벤트 동적부여..
		var btn=document.getElementById("btn");

		btn.addEventListener("click",function(){
			regist();
		});
	});


function regist(){
	//오라클 연동하려고 하지 말고, 원하는 데이터만 보내주자!!
	form1.action="/member/regist.jsp";//이 요청을 처리할 서버의 url..
	form1.submit();//전송이 일어나는 시점!
}	
</script>
</head>
<body >
	<form name="form1" method="post">
		<div id="box">
			ID<input type="text" name="id">
			Password<input type="password" name="password">
			Name<input type="text" name="name">
			<input type="button" value="등록" id="btn">
		</div>
	</form>
</body>
</html>





