package com.mongsil.youthbus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongsil.youthbus.dto.bucketDTO;

public class bucketDAO {
	private static bucketDAO inst = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// Singleton
	private bucketDAO() {

	}

	public static bucketDAO getInstance() {
		if (inst == null) {
			inst = new bucketDAO();
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
	public JSONObject selectBucketImgCount(){
		String selectQuery = "select count(*) from bucket_image";
		JSONObject obj = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				obj = new JSONObject();
				obj.put("imgcount", rs.getString(1));
				return obj;
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
		return obj;
	}
	public void insertBucketImage(String fileName){
		String insertQuery = "insert into bucket_image(bucket_img) values (?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, fileName);
			pstmt.execute();
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
	
	public JSONObject selectBucketImage(String imgInx){
		String selectQuery = "select bucket_img from bucket_image where `index` = ?";
		JSONObject obj = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setString(1, imgInx);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				obj = new JSONObject();
				obj.put("bucket_img", rs.getString("bucket_img"));
				return obj;
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
		return obj;
	}
	
	public void insertBucket(String bId, String bName, String bDate, String bImage, String bContent, String bLike, String bReply, String bGPS_X, String bGPS_Y, String bTag){
		String insertQuery = "insert into bucket(bucket_content, bucket_img, userid, nickname, bdate, bucket_like, bucket_reply, gps_x, gps_y, tag) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, bContent);
			pstmt.setString(2, bImage);
			pstmt.setString(3, bId);
			pstmt.setString(4, bName);
			pstmt.setString(5, bDate);
			pstmt.setInt(6, Integer.parseInt(bLike));
			pstmt.setInt(7, Integer.parseInt(bReply));
			pstmt.setDouble(8, Double.parseDouble(bGPS_X));
			pstmt.setDouble(9, Double.parseDouble(bGPS_Y));
			pstmt.setString(10, bTag);
			
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
	
	public JSONArray selectBucketApp(int index){
		String selectQuery = "select * from bucket order by `index` desc limit ?, 10 ";
		JSONArray jArray = new JSONArray();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bucketDTO bDTO = new bucketDTO();
				bDTO.setbIndex(rs.getString(1));
				bDTO.setbContent(rs.getString(2));
				bDTO.setbImage(rs.getString(3));
				bDTO.setbId(rs.getString(4));
				bDTO.setbName(rs.getString(5));
				bDTO.setbDate(rs.getString(6));
				bDTO.setbLike(rs.getString(7));
				bDTO.setbReply(rs.getString(8));
				bDTO.setbGPS_X(rs.getString(9));
				bDTO.setbGPS_Y(rs.getString(10));
				bDTO.setTag(rs.getString(11));
				
				JSONObject bucketOBJ = new JSONObject();
				bucketOBJ.put("bIndex", bDTO.getbIndex());
				bucketOBJ.put("bContent", bDTO.getbContent());
				bucketOBJ.put("bImage", bDTO.getbImage());
				bucketOBJ.put("bId", bDTO.getbId());
				bucketOBJ.put("bName", bDTO.getbName());
				bucketOBJ.put("bDate", bDTO.getbDate());
				bucketOBJ.put("bLike", bDTO.getbLike());
				bucketOBJ.put("bReply", bDTO.getbReply());
				bucketOBJ.put("bGPS_X", bDTO.getbGPS_X());
				bucketOBJ.put("bGPS_Y", bDTO.getbGPS_Y());
				bucketOBJ.put("Tag", bDTO.getTag());
				
				jArray.add(bucketOBJ);
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
	
	public JSONArray selectBucketWeb(int index){
		String selectQuery = "select * from bucket order by `index` desc limit ?, 100 ";
		JSONArray jArray = new JSONArray();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bucketDTO bDTO = new bucketDTO();
				bDTO.setbIndex(rs.getString(1));
				bDTO.setbContent(rs.getString(2));
				bDTO.setbImage(rs.getString(3));
				bDTO.setbId(rs.getString(4));
				bDTO.setbName(rs.getString(5));
				bDTO.setbDate(rs.getString(6));
				bDTO.setbLike(rs.getString(7));
				bDTO.setbReply(rs.getString(8));
				bDTO.setbGPS_X(rs.getString(9));
				bDTO.setbGPS_Y(rs.getString(10));
				bDTO.setTag(rs.getString(11));
				
				JSONObject bucketOBJ = new JSONObject();
				bucketOBJ.put("bIndex", bDTO.getbIndex());
				bucketOBJ.put("bContent", bDTO.getbContent());
				bucketOBJ.put("bImage", bDTO.getbImage());
				bucketOBJ.put("bId", bDTO.getbId());
				bucketOBJ.put("bName", bDTO.getbName());
				bucketOBJ.put("bDate", bDTO.getbDate());
				bucketOBJ.put("bLike", bDTO.getbLike());
				bucketOBJ.put("bReply", bDTO.getbReply());
				bucketOBJ.put("bGPS_X", bDTO.getbGPS_X());
				bucketOBJ.put("bGPS_Y", bDTO.getbGPS_Y());
				bucketOBJ.put("Tag", bDTO.getTag());
				
				jArray.add(bucketOBJ);
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
	public JSONArray selectMyBucket(String bId, int bIndex){
		String selectQuery = "select * from bucket where userid = ? order by `index` desc limit ?, ? ";
		JSONArray jArray = new JSONArray();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setString(1, bId);
			pstmt.setInt(2, bIndex);
			pstmt.setInt(3, bIndex + 10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bucketDTO bDTO = new bucketDTO();
				bDTO.setbIndex(rs.getString(1));
				bDTO.setbContent(rs.getString(2));
				bDTO.setbImage(rs.getString(3));
				bDTO.setbId(rs.getString(4));
				bDTO.setbName(rs.getString(5));
				bDTO.setbDate(rs.getString(6));
				bDTO.setbLike(rs.getString(7));
				bDTO.setbReply(rs.getString(8));
				bDTO.setbGPS_X(rs.getString(9));
				bDTO.setbGPS_Y(rs.getString(10));
				bDTO.setTag(rs.getString(11));
				
				JSONObject bucketOBJ = new JSONObject();
				bucketOBJ.put("bIndex", bDTO.getbIndex());
				bucketOBJ.put("bContent", bDTO.getbContent());
				bucketOBJ.put("bImage", bDTO.getbImage());
				bucketOBJ.put("bId", bDTO.getbId());
				bucketOBJ.put("bName", bDTO.getbName());
				bucketOBJ.put("bDate", bDTO.getbDate());
				bucketOBJ.put("bLike", bDTO.getbLike());
				bucketOBJ.put("bReply", bDTO.getbReply());
				bucketOBJ.put("bGPS_X", bDTO.getbGPS_X());
				bucketOBJ.put("bGPS_Y", bDTO.getbGPS_Y());
				bucketOBJ.put("Tag", bDTO.getTag());
				
				jArray.add(bucketOBJ);
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
	
	public void updateLike(String rIndex){
		String selectCount = "select bucket_like from bucket where `index` = ?";
		String updateCount = "update bucket set bucket_like = ? where `index` = ?";
		int likeCount;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(selectCount);
			pstmt.setInt(1, Integer.parseInt(rIndex));
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				likeCount = rs.getInt(1);
				pstmt = conn.prepareStatement(updateCount);
				likeCount++;
				pstmt.setInt(1, likeCount);
				pstmt.setInt(2, Integer.parseInt(rIndex));
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
}
