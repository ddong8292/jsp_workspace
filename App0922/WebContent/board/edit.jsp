<%@page import="com.sds.model.board.BoardDAO"%>
<%@page import="com.sds.model.board.BoardDTO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%!
	BoardDAO boarddao=new BoardDAO();
%>
<%
	request.setCharacterEncoding("utf-8");

	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String board_id=request.getParameter("board_id");
	
	BoardDTO dto=new BoardDTO();
	
	//낱개로 존재하는 파라미터들을 하나의 객체안에 담아서 처리하면
	//유지보수성이 높다
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	dto.setBoard_id(Integer.parseInt(board_id));
	
		
	int result=boarddao.update(dto);
	out.print("<script>");
	if(result!=0){
		out.print("alert('수정완료');");
		out.print("location.href='/board/detail.jsp?board_id="+board_id+"';");
		
	}else{
		out.print("alert('수정실패');");
		out.print("history.back();");
	}
	out.print("</script>");
	
%>
