package myshop.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import myshop.admin.dto.MemberDTO;

public class MemberDAO {
	private DataSource ds;
	
	public MemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//	public boolean checkMember(String name, String ssn1, String ssn2) throws SQLException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		try {
//			con = ds.getConnection();
//			String sql = "SELECT name FROM memberex WHERE ssn1=? AND ssn2=?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, ssn1);
//			ps.setString(2, ssn2);
//			rs = ps.executeQuery();
//			
//			if (rs.next()) {
//				return true;
//			}
//			
//			return false;
//		} finally {
//			if (rs != null) rs.close();
//			if (ps != null) ps.close();
//			if (con != null) con.close();
//		}
//	}
	
	public boolean loginMember(String id, String password) throws SQLException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        con = ds.getConnection();
	        String sql = "SELECT * FROM memberex WHERE id=? AND passwd=?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, id);
	        ps.setString(2, password);
	        rs = ps.executeQuery();
	        
	        return rs.next(); // 존재하는 회원인 경우 true를 반환하고, 그렇지 않은 경우 false를 반환합니다.
	    } finally {
	        if (rs != null) rs.close();
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }
	}

	
	public int insertMember(MemberDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO memberex VALUES (member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPasswd());
			ps.setString(4, dto.getSsn1());
			ps.setString(5, dto.getSsn2());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getHp1());
			ps.setString(8, dto.getHp2());
			ps.setString(9, dto.getHp3());
			
			int res = ps.executeUpdate();
			return res;
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected List<MemberDTO> makeList(ResultSet rs) throws SQLException {
		List<MemberDTO> list = new ArrayList<>();
		
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("hp1"));
			dto.setHp2(rs.getString("hp2"));
			dto.setHp3(rs.getString("hp3"));
			dto.setJoindate(rs.getString("joindate"));
			list.add(dto);
		}
		
		return list;
	}
	
	public List<MemberDTO> listMember() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM memberex";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<MemberDTO> list = makeList(rs);
			return list;
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteMember(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM memberex WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			
			int res = ps.executeUpdate();
			return res;
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public MemberDTO getMember(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM memberex WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			List<MemberDTO> list = makeList(rs);
			return list.get(0);
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int updateMember(MemberDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ds.getConnection();
			String sql = "UPDATE memberex SET passwd=?, email=?, hp1=?, hp2=?, hp3=? WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPasswd());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getHp1());
			ps.setString(4, dto.getHp2());
			ps.setString(5, dto.getHp3());
			ps.setInt(6, dto.getNo());
			
			int res = ps.executeUpdate();
			return res;
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}
