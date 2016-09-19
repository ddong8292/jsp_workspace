<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.test.Dog"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>

<%! 
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0919";
	String password="java0919";

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

%>
<%
	//로직을 작성하는 영역(스크립틀릿 영역)
	
	//드라이버 로드
	Class.forName(driver);
	out.print("드라이버 로드 성공!");
	
	//강아지 객체 생성 후 사용해보기
	Dog dog=new Dog();
	String sound=dog.bark();

	out.print("개짖는 소리는"+sound);

	//접속
	con=DriverManager.getConnection(url, user, password);
	
	if(con !=null){
		out.print("접속성공");

		String sql="select * from test";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			String name=rs.getString("name");
			int age=rs.getInt("age");
			out.print("이름:"+name+", 나이는"+age);
		}

	}else{
		out.print("접속실패");
	}
%>
<%
	if(rs !=null){
		rs.close();
	}
	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}
%>
