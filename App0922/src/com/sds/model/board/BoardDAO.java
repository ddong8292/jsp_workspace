/*
 *�� Ŭ������ ���̰� �����̰� ������� �����ͺ��̽����� �����۾��� �������� ���� �����Ͻ� ������ ��ü�̴�!!
 *
 * ���ø����̼� ���� �о߿����� �̷��� ������ ��ü�� ������ DAO(Data Access Object)�� �Ѵ�.
 * ����)java�о��� �� �ƴϱ� ������, ms ������ ��ݰ��� ���������� DOA��� �� �������� ����!!
 * 
 * DAO�� �ֿ� ������ CRUD(Create(=insert) Read(=select) Update Delete)�̴�.
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
	
	//�Խù� 1�� �ֱ�!!
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
	
	//�Խù� ��� ��������!!
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
			
			//rs�� �� ������ �ǹǷ� rs�� ����Ҹ��� ��ü���� �̿��غ���!
			
			while(rs.next()){	
				BoardDTO dto=new BoardDTO();//�ֺ� DTO
				
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getNString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));
				
				list.add(dto);//�÷��ǿ� �Խù� 1�� �߰�!!
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con,pstmt,rs);
		}
		return list;
	}
	//�Խù� 1�� ��������!!
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
			
			//���ڵ尡 �ִٸ�..
			if(rs.next()){
				dto=new BoardDTO();
				
				//dto�� ���ڵ��� �÷������� ���Խ�Ű��!!(injection)
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
	//���ڵ� 1�� ����!!
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
	//�Խù� 1�� ����!!
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
