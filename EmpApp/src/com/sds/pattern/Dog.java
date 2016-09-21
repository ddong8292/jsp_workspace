/*
 * 이 강아지 일반 클래스의 인스턴스를 메모리에 한번만 올리도록 처리해 보자!!. 이러한 개발방법을 SingleTon Pattern
 * 이라 하며, GOF가 저서한 Design Parttern 이라는 책에서 붙여진 이름이다..
 * */
package com.sds.pattern;

public class Dog {
	private static Dog instance;
	
	private Dog(){
		
	}
	public static Dog getInstance(){
		if(instance==null){
			instance=new Dog();
		}
			return instance;
	}
}
