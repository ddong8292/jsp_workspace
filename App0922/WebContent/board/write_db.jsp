<%@page import="com.sds.model.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	BoardDAO boardao=new BoardDAO();
%>
 <% 
	//글쓰기 폼 양식으로부터 전송되어온 파라미터값들을 이용하여, 오라클에 insert 시키자!!
	//그리고 나서 다시 list를 보여주자
	request.setCharacterEncoding("utf-8");

	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	out.print(writer);
	out.print(title);
	out.print(content);
	
	int result=boardao.insert(writer, title, content);
	
	out.print("<script>");
	if(result!=0){
		out.print("alert('등록성공');");
		//클라이언트의 브라우저로 하여금 지정된 url로 재접속을 명령한다!
		out.print("location.href='/board/list.jsp';"); 
	}else{
		out.print("alert('등록실패');");
		out.print("history.back();");
	}
	out.print("</script>");
	
	
%>