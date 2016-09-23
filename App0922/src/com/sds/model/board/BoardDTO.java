/*
 *�� Ŭ������ ������ �ۼ��ϱ� ������ �ƴ϶�, �����ͺ��̽��� �ϳ��� ���ڵ带 ��� ���� ��ü�� Ȱ���ϱ� �����̴�.
 *
 *���ø����̼� ����о߿��� �̷��� ������ ��ü�� ������ DTO(Date Transfer Object(������ ���ް�ü)), 
 *VO(Value Object(�����͸� ��� ��ü))��� �θ���.
 * 
 * */
package com.sds.model.board;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

public class BoardDTO {
	//�����ʹ� ��ȣ�ؾ� �Ѵ�
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