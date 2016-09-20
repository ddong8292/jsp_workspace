/*
	서블릿이란? 서버에서만 해석 및 실행되는 클래스를 의미한다
*/
package com.site0920.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	//서블릿의 생명주기 중, 최초에 인스턴스 생성시 서버의 정보를 넘겨받기 위한 과정으로, 아래의 init이 호출
	//서블릿의 일생 중 단 한번만 호출됨..(태어난 즉시)
	//생성자와는 틀리다. 즉 생성 후 호출이므로, 호출 시점을 비교하자면 생성자보다는 늦다.
	public void init(){
		System.out.println("나 지금 막 태어났어요!!");
	}

	//생성된 서블릿이 업무를 처리할때 호출되는 메서드
	//즉, 클라이언트의 요청이 들어올때마다 호출되는 메서드..
	//service 메서드는 클라이언트의 오청을 처리해야 하므로, 클라이언트가 요청시 전달한 정보 등을 알아야 한다. 따라서,
	//request객체, response 객체를 인수로 받는다..
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("요청을 처리하겠습니다");
	}
	//서블릿의 인스턴스가 소멸될때, 단 한번 호출되는 메서드. 
	//더 이상 사용하지 않을 자원등을 반납할때 유용.
	public void destroy(){
		System.out.println("저 갑니다~");
	}
}


