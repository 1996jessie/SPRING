package com.spring.ex.dao;

import java.sql.*;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static FDao instance;

	public static FDao getInstance() {
		if (instance == null) {
			instance = new FDao();
		}
		return instance;
	} //getInstance

	private FDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //FDao

	public void insert(FDto fdto) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into football values (fb_seq.nextval, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	}
	
	public ArrayList<FDto> selectAll() {
		ArrayList<FDto> lists = new ArrayList<FDto>();
		try {
			String sql = "select * from football order by num";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FDto fdto = null;
				fdto = getFDto(rs);
				lists.add(fdto);
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
			String sql = "delete from football where num = ?";
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

	public FDto selectFootballByNum(int num) {
		// TODO Auto-generated method stub
		FDto fdto = null;
		String sql = "select * from football where num = ?";
		try {
			ps = conn.prepareStatement(sql);	
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				fdto = getFDto(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
		return fdto;
		
	}

	public void update(FDto fdto) {
		// TODO Auto-generated method stub
		try {
			String sql = "update football set id = ?, pw = ?, win = ?, round16 = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			ps.setInt(5, fdto.getNum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	}
	
	private FDto getFDto(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		FDto fdto = new FDto();
		fdto.setNum(rs.getInt("num"));
		fdto.setId(rs.getString("id"));
		fdto.setPw(rs.getString("pw"));
		fdto.setWin(rs.getString("win"));
		fdto.setRound16(rs.getString("round16"));
		
		return fdto;
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
