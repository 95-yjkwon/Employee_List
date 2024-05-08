package com.keduit.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.keduit.dto.EmployeeVO;
import com.keduit.util.DBManager;

public class EmployeeDAO {
	private EmployeeDAO() {}
	private static EmployeeDAO instance=new EmployeeDAO();
	
	public static EmployeeDAO getInstance() {
		return instance;
	}
	
	public List<EmployeeVO>selectAllEmployee(){
		String sql="select *from EMPLOYEES";
		List<EmployeeVO>list=new ArrayList<EmployeeVO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=DBManager.getconConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				EmployeeVO eVO=new EmployeeVO();
				eVO.setEnter(rs.getDate("enter"));
				eVO.setGender(rs.getString("gender"));
				eVO.setId(rs.getString("id"));
				eVO.setLev(rs.getString("lev"));
				eVO.setName(rs.getString("name"));
				eVO.setPass(rs.getString("pass"));
				eVO.setPhone(rs.getString("phone"));
				
				list.add(eVO);
				
			}
			
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, stmt, rs);
			}
			return list;
		}

	public void insertEmployee(EmployeeVO eVO) {
		String sql="insert into EMPLOYEES("
						+"id, pass, name, lev, gender, phone) "
						+"values(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getconConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, eVO.getId());
			pstmt.setString(2, eVO.getPass());
			pstmt.setString(3, eVO.getName());
			pstmt.setString(4, eVO.getLev());
			pstmt.setString(5, eVO.getGender());
			pstmt.setString(6, eVO.getPhone());
			
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public EmployeeVO selectOne(String id) {
		
		EmployeeVO eVO=null;
		String sql="select *from EMPLOYEES where id=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBManager.getconConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				eVO=new EmployeeVO();
				eVO.setId(rs.getString("id"));
				eVO.setName(rs.getString("name"));
				eVO.setPass(rs.getString("pass"));
				eVO.setPhone(rs.getString("phone"));
				eVO.setLev(rs.getString("lev"));
				eVO.setGender(rs.getString("gender"));
				eVO.setEnter(rs.getDate("enter"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println("----------------selectOne="+eVO);
		return eVO;
	}

	public void deleteEmployee(String id) {
		String sql="delete from EMPLOYEES where id=?";
		System.out.println("delete======="+id);
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getconConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			int result=pstmt.executeUpdate();
			System.out.println("삭제결과:"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void updateEmployee(EmployeeVO eVO) {
		String sql="update EMPLOYEES set id=?, pass=?, name=?, lev=?, gender=?, phone=? where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getconConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, eVO.getId());
			pstmt.setString(2, eVO.getPass());
			pstmt.setString(3, eVO.getName());
			pstmt.setString(4, eVO.getLev());
			pstmt.setString(5, eVO.getGender());
			pstmt.setString(6, eVO.getPhone());
			pstmt.setString(7, eVO.getId());
			
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	}

