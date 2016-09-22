<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	//선택한 사원 한사람에 대한 정보를 가져와서 출력해보자!!
 	String empno=request.getParameter("empno");
 
 	String sql="select * from emp where empno="+empno;
 	out.print(sql);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function change(){
	
}
function del(){
	
}
function list(){
	
}
</script>
</head>
<body bgcolor="pink">
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
				
				<input type="button" value="수정" name="change()">
				<input type="button" value="삭제" name="del()">
				<input type="button" value="목록" name="list()">
			</pre>
		</div>
	</form>
</body>
</html>