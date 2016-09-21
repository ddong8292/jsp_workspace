<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function regist(){
	//오라클에 insert 시켜달라고 서버측에 요청하자!!
	form1.action="/regist";//요청할 서버의 url
	form1.submit();//전송 행위!! 전송이 일어나는 시점!!
}
//이전화면 보여주기!
function prev(){
	history.back();
}

</script>
</head>
<body bgcolor="yellow">
	<form name="form1" method="post">
		<div>
			<pre>
				EMPNO:		<input type="text" name="empno">
				ENAME:		<input type="text" name="ename">
				JOB:		<input type="text" name="job">
				MGR:		<input type="text" name="mgr">
				HIREDATE :	<input type="text" name="hiredate">
				SAL:		<input type="text" name="sal">
				COMM:		<input type="text" name="comm">
				DEPTNO:		<input type="text" name="deptno">
				
				<input type="button" value="등록" onClick="regist()">
				<input type="button" value="뒤로가기" onClick="prev()">
			</pre>
		</div>
	</form>
</body>
</html>