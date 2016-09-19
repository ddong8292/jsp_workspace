<%@ page contentType="text/html;charset=utf-8"%>
<%!
	//이 영역에 선언된 변수와 메서드는 멤버로 취급..
	int price=300;
	
	public String getMsg(){
		return "apple";
	}
%>
<%
	/*
		jsp는 자바의 문법을 그대로 사용할 수 있으며, 크게 3가지 영역으로 구분된다..(즉 jsp 코드를 기재할 수 있는
		영역은 총 3가지)
		
		1.지시영역		1번라인 [%@ %]
			: 현재 jsp에 대한 설정 정보를 기재하는 영역

		2.선언부	2번라인 [%! %]
			: 멤버변수와 멤버메서드를 기재할 수 있는 영역

		3.스크립틀릿 영역	[%@ %]
			: 로직을 작성하는 영역
	*/
	String msg=getMsg();
	out.print(msg+"의 가격은?"+price);


%>