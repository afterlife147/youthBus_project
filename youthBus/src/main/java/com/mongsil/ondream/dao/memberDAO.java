package com.mongsil.ondream.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class memberDAO {
	
	private static memberDAO inst = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// Singleton
	private memberDAO() {

	}

	public static memberDAO getInstance() {
		if (inst == null) {
			inst = new memberDAO();
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
	
	public int memberInsert(String id, String pwd, String age, String gender) {
		String selectQuery = "select userid from on_member where userid = ?";
		String insertQuery = "insert into on_member(userid, userpwd, age, gender) values (?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return 1;
			} else {
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setInt(3, Integer.parseInt(age));
				pstmt.setString(4, gender);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return 0;
	}	
	
	public int memberselect(String id , String pwd){
		int result = 0;
		String selectQuery = "select userid, userpwd from on_member where userid = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if(rs.getString(1).equals(id)){
					if(rs.getString(2).equals(pwd)){
						result = 1;
						return result;
					}else{
						result = 2;
						return result;
					}
				}
			}else{
				result = 0;
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}
}
