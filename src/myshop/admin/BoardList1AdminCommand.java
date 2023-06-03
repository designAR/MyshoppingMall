package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;
import myshop.admin.dto.BoardDTO;

public class BoardList1AdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BoardDAO dao = new BoardDAO();
        try {
            int start = 1; 
            int end = 10; 

            List<BoardDTO> list = dao.listBoard(start, end);
            req.setAttribute("listBoard", list);
            return "WEB-INF/shop/admin/board_list1.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            String msg = "board list 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
            String url = "main_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp";
        }
    }
}
