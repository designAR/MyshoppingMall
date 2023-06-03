package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;
import myshop.admin.dto.BoardDTO;

public class BoardUpdateAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pnum = req.getParameter("num");
        BoardDAO dao = new BoardDAO();
        try {
            BoardDTO dto = dao.getBoard(Integer.parseInt(pnum), "content");
            req.setAttribute("dto", dto); 
            return "WEB-INF/shop/admin/board_update.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "boardupdate 실행 중 DB 오류 발생!! 관리자에게 문의하세요");
            req.setAttribute("url", "main_admin.do");
            return "message.jsp";
        }
    }
}
