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
	
	
}
