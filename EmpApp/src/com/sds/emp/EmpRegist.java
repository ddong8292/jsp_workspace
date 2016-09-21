package com.sds.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.pool.PoolManager;

public class EmpRegist extends HttpServlet{
	PoolManager pool=PoolManager.getInstance();
	//DML 중 insert 문을 수행하기 위한 jdbc 객체들..
	Connection con;
	PreparedStatement pstmt;
	
	
	//클라이언트의 요청방식이 post일 경우 아래의 메서드가 service() 에 의해 호출된다!!
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//클라이언트가 넘긴 데이터의 인코딩처리!
		req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html");
		//클라이언트의 브라우저에 출력할 문자열에 대한 인코딩처리
		res.setCharacterEncoding("utf-8");
		
		PrintWriter out=res.getWriter();
		out.print("이 서블릿에서 오라클에 insert 시키겠습니다");
		
		//접속 객체 대여!!
		try {
			con=pool.getConnection();
			
			String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)";
			sql=sql+" values(?,?,?,?,?,?,?,?)";
			
			//클라이언트가 전송한 요청파라미터 값들을 끄집어 내자!!
			//요청 정보이므로, HttpSerVletRequest객체가 보유하고 있다!!
			
			
			pstmt=con.prepareStatement(sql);
			
			//총 8개의 바인드 변수값을 지정한다!!
			String empno=req.getParameter("empno");
			String ename=req.getParameter("ename");
			String job=req.getParameter("job");
			String mgr=req.getParameter("mgr");
			String hiredate=req.getParameter("hiredate");
			String sal=req.getParameter("sal");
			String comm=req.getParameter("comm");
			String deptno=req.getParameter("deptno");
			//out.print("넘어온 ename값은"+ename);
			
			pstmt.setInt(1,Integer.parseInt(empno));
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4,Integer.parseInt(mgr));
			pstmt.setString(5, hiredate);
			pstmt.setInt(6,Integer.parseInt(sal));
			pstmt.setInt(7,Integer.parseInt(comm));
			pstmt.setInt(8,Integer.parseInt(deptno));
			
			
			int result=pstmt.executeUpdate();
			
			if(result !=0){
				out.print("<script>");
				out.print("alert('등록성공');");
				out.print("location.href='/list';");
				out.print("</script>");
			}else{
				out.print("<script>");
				out.print("alert('등록실패');");
				out.print("history.back();");
				out.print("</script>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt);
		}
		
	}
	
}
