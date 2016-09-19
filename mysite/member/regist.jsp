<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>

<%
	//클라이언트가 전송한 데이터를 받아서 오라클에 insert 시켜보자!!

	//클라이언트가 현재 페이지를 요청하면서 보낸 파라미터를 낚아채보자!!
	
	request.setCharacterEncoding("utf-8");//파라미터에 대한 언어 인코딩 지정하면 깨지지 않는다!!

	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String name=request.getParameter("name");

	out.print("넘겨받은 id는?"+id);
	out.print("넘겨받은 password는?"+password);
	out.print("넘겨받은 name는?"+name);

	String sql="insert into member(member_id,id,password,name)";
	sql=sql+"values(seq_member.nextval,?,?,?)";
	
	out.print(sql);

	//드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//접속
	Connection con=null;
	PreparedStatement pstmt=null;
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java0919","java0919");

	//쿼리수행

	if(con !=null){
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		
		int result=pstmt.executeUpdate();
		if(result !=0){
			out.print("등록성공");
		}else{
			out.print("등록실패");
		}
	}

	//닫기
	%>
<%
	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}

%>