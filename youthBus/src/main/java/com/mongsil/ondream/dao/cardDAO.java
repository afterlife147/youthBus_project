package com.mongsil.ondream.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongsil.youthbus.dto.bucketDTO;

public class cardDAO {
	
	private static cardDAO inst = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// Singleton
	private cardDAO() {

	}

	public static cardDAO getInstance() {
		if (inst == null) {
			inst = new cardDAO();
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
	
	public JSONArray selectCard(int index){
		String selectQuery = "select * from on_card order by `cIndex` desc limit ?, 10 ";
		JSONArray jArray = new JSONArray();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){				
				JSONObject cardOBJ = new JSONObject();
				cardOBJ.put("cIndex", rs.getInt(1));
				cardOBJ.put("cUserId", rs.getString(2));
				cardOBJ.put("cContent", rs.getString(3));
				cardOBJ.put("cImage", rs.getString(4));
				cardOBJ.put("cTime", rs.getString(5));
				cardOBJ.put("cHeart", rs.getString(6));
				cardOBJ.put("cReply", rs.getString(7));			
				jArray.add(cardOBJ);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jArray;
	}
	
	public void insertCard(String cuserId, String cContent, String cImage, String cTime){
		String insertQuery = "insert into on_card(cUserId, cContent, cImage, cTime) values (?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, cuserId);
			pstmt.setString(2, cContent);
			pstmt.setString(3, cImage);
			pstmt.setString(4, cTime);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
