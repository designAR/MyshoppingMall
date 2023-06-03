package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;
import myshop.admin.dto.BoardDTO;

public class BoardContentAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        BoardDAO dao = new BoardDAO();
        try {
            BoardDTO dto = dao.getBoard(num, "content");
            req.setAttribute("dto", dto); 
            return "WEB-INF/shop/admin/board_content.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            String msg = "게시글 조회 중 DB 오류 발생!! 관리자에게 문의하세요";
            String url = "boardList1_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp";
        }
    }
}
