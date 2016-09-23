/*
 *이 클래스는 로직을 작성하기 위함이 아니라, 데이터베이스의 하나의 레코드를 담기 위한 객체로 활용하기 위함이다.
 *
 *어플리케이션 설계분야에서 이러한 목적의 객체를 가리켜 DTO(Date Transfer Object(데이터 전달객체)), 
 *VO(Value Object(데이터를 담는 객체))라고 부른다.
 * 
 * */
package com.sds.model.board;


public class BoardDTO {
	//데이터는 보호해야 한다
	private int board_id;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
}
