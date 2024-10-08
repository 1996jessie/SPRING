package com.spring.ex.dao;

import java.sql.*;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static PDao instance;

	public static PDao getInstance() {
		if (instance == null) {
			instance = new PDao();
		}
		return instance;
	} //getInstance

	private PDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //PDao

	public void insert(PDto pdto) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into person values (person_seq.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getId());
			ps.setString(2, pdto.getName());
			ps.setInt(3, pdto.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	}

	public ArrayList<PDto> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<PDto> lists = new ArrayList<PDto>();
		try {
			String sql = "select * from person order by num";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PDto pdto = null;
				pdto = getPDto(rs);
				lists.add(pdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
		return lists;
	}


	public void delete(int num) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from person where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	}

	public PDto selectPersonByNum(int num) {
		// TODO Auto-generated method stub
		PDto pdto = null;
		try {
			String sql = "select * from person where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				pdto = getPDto(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
		return pdto;
	}

	public void update(PDto pdto) {
		// TODO Auto-generated method stub
		try {
			String sql = "update person set id = ?, name = ?, age = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getId());
			ps.setString(2, pdto.getName());
			ps.setInt(3, pdto.getAge());
			ps.setInt(4, pdto.getNum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	}
	

	private PDto getPDto(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		PDto pdto = new PDto();
		pdto.setNum(rs.getInt("num"));
		pdto.setId(rs.getString("id"));
		pdto.setName(rs.getString("name"));
		pdto.setAge(rs.getInt("age"));
		
		return pdto;
	}
	
	private void fin() {
		// TODO Auto-generated method stub
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
