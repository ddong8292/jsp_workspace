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
import java.sql.SQLException;
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
	//게시물 1건 가져오기!!
	public BoardDTO select(int board_id){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDTO dto=null;
		
		try {
			con=pool.getConnection();
			String sql="select*from board where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs=pstmt.executeQuery();
			
			//레코드가 있다면..
			if(rs.next()){
				dto=new BoardDTO();
				
				//dto에 레코드의 컬럼값들을 주입시키자!!(injection)
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt,rs);
		}
		return dto;
		
		
	}
	//레코드 1건 삭제!!
	public int delete(int board_id){
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			con=pool.getConnection();
			String sql="delete from board where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,board_id);
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt);
		}
		return result;
	}
	//게시물 1건 수정!!
	public int update(BoardDTO dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			con=pool.getConnection();
			String sql="update board set writer=?,title=?,";
			sql=sql+"content=? where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getBoard_id());
			
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt);
		}
		return result;
	}
}
