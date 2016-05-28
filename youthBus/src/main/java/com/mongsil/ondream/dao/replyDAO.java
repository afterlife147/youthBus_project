package com.mongsil.ondream.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongsil.ondream.dto.replyDTO;
import com.mongsil.youthbus.dto.bucketReplyDTO;

public class replyDAO {
	
	private static replyDAO inst = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// Singleton
	private replyDAO() {

	}

	public static replyDAO getInstance() {
		if (inst == null) {
			inst = new replyDAO();
		}
		return inst;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/mongsil311");
		conn = ds.getConnection();

		return conn;
	}
	
	public void insertReply(String rCardIndex, String rUserId, String rContent, String rTime){
		String insertQuery = "insert into on_card_reply(rCardIndex, rUserId, rContent, rTime) values (?, ?, ?, ?)";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, Integer.parseInt(rCardIndex));
			pstmt.setString(2, rUserId);
			pstmt.setString(3, rContent);
			pstmt.setString(4, rTime);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public JSONArray selectReply(int cardIndex){
		String selectQuery = "select * from on_card_reply where rCardIndex = ? order by `rIndex` desc";
		JSONArray jArray = new JSONArray();
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, cardIndex);

			rs = pstmt.executeQuery();
			while(rs.next()){
				replyDTO rDTO = new replyDTO();
				rDTO.setrIndex(rs.getInt(1));
				rDTO.setrCardIndex(rs.getInt(2));
				rDTO.setrUserId(rs.getString(3));
				rDTO.setrContent(rs.getString(4));
				rDTO.setrTime(rs.getString(5));
				
				JSONObject replyOBJ = new JSONObject();
				replyOBJ.put("rIndex", rDTO.getrIndex());
				replyOBJ.put("rCardIndex", rDTO.getrCardIndex());
				replyOBJ.put("rUserId", rDTO.getrUserId());
				replyOBJ.put("rContent", rDTO.getrContent());
				replyOBJ.put("rTime", rDTO.getrTime());
				
				jArray.add(replyOBJ);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return jArray;
	}
}
