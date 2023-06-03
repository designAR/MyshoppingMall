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

import com.oreilly.servlet.MultipartRequest;

import myshop.admin.dto.ProductDTO;

public class ProductDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DataSource ds;
	static {
		try {
			Context initContext = new InitialContext();
			ds = (DataSource)initContext.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int insertProd(MultipartRequest mr) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "insert into product values(prod_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			String pcategory_fk = mr.getParameter("pcategory_fk");
			pcategory_fk += mr.getParameter("pcode");
			ps.setString(2, pcategory_fk);
			ps.setString(3, mr.getParameter("pcompany"));
			ps.setString(4, mr.getFilesystemName("pimage"));
			ps.setInt(5, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(6, Integer.parseInt(mr.getParameter("price")));
			ps.setString(7, mr.getParameter("pspec"));
			ps.setString(8, mr.getParameter("pcontents"));
			ps.setInt(9, Integer.parseInt(mr.getParameter("point")));
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	protected List<ProductDTO> makeList(ResultSet rs) throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPcategory_fk(rs.getString("pcategory_fk"));
			dto.setPcompany(rs.getString("pcompany"));
			dto.setPimage(rs.getString("pimage"));
			dto.setPqty(rs.getInt("pqty"));
			dto.setPrice(rs.getInt("price"));
			dto.setPspec(rs.getString("pspec"));
			dto.setPcontents(rs.getString("pcontents"));
			dto.setPoint(rs.getInt("point"));
			dto.setPinputdate(rs.getString("pinputdate"));
			list.add(dto);
		}
		return list;
	}
	public List<ProductDTO> listProd() throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from product";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ProductDTO getProduct(int pnum) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list.get(0);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteProd(int pnum) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "delete from product where pnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int updateProd(MultipartRequest mr) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "update product set pname=?, pcompany=?, pimage=?, pqty=?, "
					+ "price=?, pspec=?, pcontents=?, point=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, mr.getParameter("pcompany"));
			String pimage = mr.getFilesystemName("pimage");
			if (pimage == null) {
				pimage = mr.getParameter("pimage2");
			}
			ps.setString(3, pimage);
			ps.setInt(4, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
			ps.setString(6, mr.getParameter("pspec"));
			ps.setString(7, mr.getParameter("pcontents"));
			ps.setInt(8, Integer.parseInt(mr.getParameter("point")));
			ps.setInt(9, Integer.parseInt(mr.getParameter("pnum")));
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<ProductDTO> listPspec(String pspec) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pspec = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pspec);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<ProductDTO> listCode(String code) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pcategory_fk like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code+"%");
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}














