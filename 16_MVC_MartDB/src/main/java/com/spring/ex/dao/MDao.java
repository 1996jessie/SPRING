package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.MartBean;

public class MDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MDao instance;

	public static MDao getInstance() {
		if (instance == null) {
			instance = new MDao();
		}
		return instance;
	} //getInstance

	private MDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //MDao

	public void insert(MartBean mb) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into mart values (m_seq.nextval, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPw());
			ps.setString(3, mb.getProduct());
			ps.setString(4, mb.getTime());
			ps.setString(5, mb.getApprove());
			ps.setString(6, mb.getAgree());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	} //insert
	
	public ArrayList<MartBean> selectAll() {
		ArrayList<MartBean> lists = new ArrayList<MartBean>();
		try {
			String sql = "select * from mart order by num";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MartBean mb = null;
				mb = getMartBean(rs);
				lists.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
		return lists;
	} //selectAll

	public void delete(int num) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from mart where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	} //delete

	public MartBean selectMartByNum(int num) {
		// TODO Auto-generated method stub
		MartBean mb = null;
		String sql = "select * from mart where num = ?";
		try {
			ps = conn.prepareStatement(sql);	
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				mb = getMartBean(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
		return mb;
	} //selectMartByNum

	public void update(MartBean mb) {
		// TODO Auto-generated method stub
		try {
			String sql = "update mart set id = ?, pw = ?, product = ?, time = ?, approve = ?, agree = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPw());
			ps.setString(3, mb.getProduct());
			ps.setString(4, mb.getTime());
			ps.setString(5, mb.getApprove());
			ps.setString(6,  mb.getAgree());
			ps.setInt(7, mb.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	} //update

	public void deleteAll(String[] rowcheck) {
		// TODO Auto-generated method stub
		try {
			int i;
			String sql = "delete from mart where num = ?";
			for(i=1;i<rowcheck.length;i++) {
				sql += " or num = ?";
			}
			ps = conn.prepareStatement(sql);
			for(i=0;i<rowcheck.length;i++) {
				ps.setInt(i+1, Integer.parseInt(rowcheck[i]));
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fin();
		}
	} //deleteAll
	
	private MartBean getMartBean(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		MartBean mb = new MartBean();
		mb.setNum(rs.getInt("num"));
		mb.setId(rs.getString("id"));
		mb.setPw(rs.getString("pw"));
		mb.setProduct(rs.getString("product"));
		mb.setTime(rs.getString("time"));
		mb.setApprove(rs.getString("approve"));
		mb.setAgree(rs.getString("agree"));
		
		return mb;
	} //getMartBean

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
	} //fin
}
