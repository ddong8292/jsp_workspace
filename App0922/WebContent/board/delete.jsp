<%@page import="com.sds.model.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	BoardDAO boarddao=new BoardDAO();
%>
<%
	//넘겨받은 파라미터값을 이용하여 delete수행
	String board_id=request.getParameter("board_id");
	int result=boarddao.delete(Integer.parseInt(board_id));
	
	out.print("<script>");
	if(result!=0){
		out.print("alert('삭제완료');");
		out.print("location.href='/board/list.jsp';");
	}else{
		out.print("alert('삭제실패');");
		out.print("history.back();");
	}
	out.print("</script>");
%>