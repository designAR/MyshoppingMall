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

import myshop.admin.dto.BoardDTO;

public class BoardDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private static DataSource ds;
    static {
        try {
            Context initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected List<BoardDTO> makeList(ResultSet rs) throws SQLException {
        List<BoardDTO> list = new ArrayList<>();
        while (rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setNum(rs.getInt("num"));
            dto.setWriter(rs.getString("writer"));
            dto.setEmail(rs.getString("email"));
            dto.setSubject(rs.getString("subject"));
            dto.setPasswd(rs.getString("passwd"));
            dto.setReg_date(rs.getString("reg_date"));
            dto.setReadcount(rs.getInt("readcount"));
            dto.setContent(rs.getString("content"));
            dto.setIp(rs.getString("ip"));
            list.add(dto);
        }
        return list;
    }

    public List<BoardDTO> listBoard(int start, int end) throws SQLException {
        try {
            con = ds.getConnection();
            String sql = "select * from (select rownum rn, A.* from " + "(select * from boardex order by num desc)A) "
                    + "where rn between ? and ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, end);
            rs = ps.executeQuery();
            List<BoardDTO> list = makeList(rs);
            return list;
        } finally {
            close();
        }
    }

    public int insertBoard(BoardDTO dto) throws SQLException {
        try {
            con = ds.getConnection();
            String sql = "insert into boardex values(board_seq.nextval, ?,?,?,?,sysdate,0,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getWriter());
            ps.setString(2, dto.getEmail());
            ps.setString(3, dto.getSubject());
            ps.setString(4, dto.getPasswd());
            ps.setString(5, dto.getContent());
            ps.setString(6, dto.getIp());
            int res = ps.executeUpdate();
            return res;
        } finally {
            close();
        }
    }

    protected void plusReadcount(int num) throws SQLException {
        try {
            con = ds.getConnection();
            String sql = "update boardex set readcount = readcount + 1 where num = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ps.executeUpdate();
        } finally {
            close();
        }
    }

    public BoardDTO getBoard(int num, String mode) throws SQLException {
        try {
            if (mode.equals("content")) {
                plusReadcount(num);
            }
            con = ds.getConnection();
            String sql = "select * from boardex where num = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            List<BoardDTO> list = makeList(rs);
            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } finally {
            close();
        }
    }

    public int deleteBoard(int num, String passwd) throws SQLException {
        try {
            BoardDTO dto = getBoard(num, "password");
            if (dto != null && dto.getPasswd().equals(passwd)) {
                con = ds.getConnection();
                String sql = "delete from boardex where num = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, num);
                int res = ps.executeUpdate();
                return res;
            } else {
                return -1;
            }
        } finally {
            close();
        }
    }

    public int updateBoard(BoardDTO dto) throws SQLException {
        try {
            BoardDTO dto2 = getBoard(dto.getNum(), "password");
            if (dto2 != null && dto2.getPasswd().equals(dto.getPasswd())) {
                con = ds.getConnection();
                String sql = "update boardex set writer=?, subject=?, " + "email=?, content=? where num = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getWriter());
                ps.setString(2, dto.getSubject());
                ps.setString(3, dto.getEmail());
                ps.setString(4, dto.getContent());
                ps.setInt(5, dto.getNum());
                int res = ps.executeUpdate();
                return res;
            } else {
                return -1;
            }
        } finally {
            close();
        }
    }

    public int getCount() throws SQLException {
        try {
            con = ds.getConnection();
            String sql = "select count(*) from boardex";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count;
        } finally {
            close();
        }
    }

    protected void close() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
