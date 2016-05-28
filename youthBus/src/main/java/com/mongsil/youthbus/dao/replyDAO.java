package com.mongsil.youthbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
	
	public void bucketReplyInsert(String userId, int bucketId, String rName, String content, String writeTime){
		String insertQuery = "insert into bucket_reply(userid, bucketid, name, content, writetime) values (?, ?, ?, ?, ?)";
		String selectCount = "select bucket_reply from bucket where `index` = ?";
		String updateCount = "update bucket set bucket_reply = ? where `index` = ?";
		int replyCount = 0;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, userId);
			pstmt.setInt(2, bucketId);
			pstmt.setString(3, rName);
			pstmt.setString(4, content);
			pstmt.setString(5, writeTime);
			pstmt.execute();
			
			pstmt = conn.prepareStatement(selectCount);
			pstmt.setInt(1, bucketId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				replyCount = rs.getInt(1);
				pstmt = conn.prepareStatement(updateCount);
				replyCount++;
				pstmt.setInt(1, replyCount);
				pstmt.setInt(2, bucketId);
				pstmt.execute();
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
	}
	
	public JSONArray bucketReplySelect(int CardIndex){
		String selectQuery = "select * from bucket_reply where bucketid = ? order by `index` desc";
		JSONArray jArray = new JSONArray();
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, CardIndex);

			rs = pstmt.executeQuery();
			while(rs.next()){
				bucketReplyDTO rDTO = new bucketReplyDTO();
				rDTO.setIndex(rs.getInt(1));
				rDTO.setUserId(rs.getString(2));
				rDTO.setBucketId(rs.getInt(3));
				rDTO.setName(rs.getString(4));
				rDTO.setContent(rs.getString(5));
				rDTO.setWriteTime(rs.getString(6));
				
				JSONObject replyOBJ = new JSONObject();
				replyOBJ.put("rIndex", rDTO.getIndex());
				replyOBJ.put("rUserId", rDTO.getUserId());
				replyOBJ.put("rBucketId", rDTO.getBucketId());
				replyOBJ.put("rName", rDTO.getName());
				replyOBJ.put("rContent", rDTO.getContent());
				replyOBJ.put("rWriteTime", rDTO.getWriteTime());
				
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
