/*
 *이 클래스는 웹이건 응용이건 상관없이 데이터베이스와의 연동작업에 공통으로 사용될 비지니스 로직용 객체이다!!
 *
 * 어플리케이션 설계 분야에서는 이러한 목적의 객체를 가리켜 DAO(Data Access Object)라 한다.
 * 주의)java분야의 용어가 아니기 때문에, ms 진영의 닷넷개발 진영에서도 DOA라는 용어를 공통으로 쓴다!!
 * 
 * DAO의 주요 업무는 CRUD(Create(=insert) Read(=select) Update Delete)이다.
 * */

package com.sds.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sds.pool.PoolManager;

public class BoardDAO {
	PoolManager pool=PoolManager.getInstance();
	
	//게시물 1건 넣기!!
	public int insert(String writer, String title, String content){
		int result=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=pool.getConnection();

			String sql="insert into board(board_id, writer, title, content)";
			sql=sql+" values(seq_board.nextval,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con, pstmt);
		}
		return result;
		
	}
	
	//게시물 모두 가져오기!!
	public List selectAll(){
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardDTO> list=new ArrayList<BoardDTO>();
		
		try {
			con=pool.getConnection();
			String sql="select * from board order by board_id desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//rs가 곧 닫히게 되므로 rs를 대용할만한 대체물을 이용해보자!
			
			while(rs.next()){	
				BoardDTO dto=new BoardDTO();//텅빈 DTO
				
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getNString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));
				
				list.add(dto);//컬렉션에 게시물 1건 추가!!
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt,rs);
		}
		return list;
	}
	
	
}
