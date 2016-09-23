<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//클라이언트가 전송한 파라미터와 파일을 넘겨받아 서버의 하드디스크에 적재시지카=업로드
	//직접개발하지 말고, 외부 라이브러리 이용해보자!
	//String saveDir="C:/jsp_workspace/App0923/WebContent/data";
	String saveDir="/Users/pch/Documents/jsp_workspace/App0923/WebContent/data";
	int maxSize=2*1024*1024;	
	request.setCharacterEncoding("utf-8");
	
	//생성시 업로드도 실행!!
	
	MultipartRequest multi=new MultipartRequest(request, saveDir,maxSize, "utf-8");
	String msg=multi.getParameter("msg");
	out.print("넘겨받은 메세지는"+msg);
	
	//파일명을 출력하시오!!
	String myFile=multi.getOriginalFileName("myFile");
	out.print("<br>");
	out.print("업로드하신 파일명은:"+myFile);
	
	//파일명을 바꿔보자!
		
	//1단계-이미 업로드된 파일에 대한 인스턴스 얻기!!
	File file=multi.getFile("myFile");
	
	//2단계=renameTo를 이용하여 파일의 이름을 교체!!
	//확장자 얻기
	int index=myFile.lastIndexOf(".");//가장 마지막점의 index얻기
	String ext=myFile.substring(index+1, myFile.length());		
	
	boolean result=file.renameTo(new File(saveDir+"/"+msg+"."+ext));
	if(result){
		out.print("변경 성공");
	}else{
		out.print("변경 실패");
	}
%>