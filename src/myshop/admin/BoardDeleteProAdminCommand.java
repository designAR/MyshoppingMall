package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;

public class BoardDeleteProAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        String passwd = req.getParameter("passwd");
        BoardDAO dao = new BoardDAO();
        String msg = null;
        String url = "boardList1_admin.do";
        try {
            int res = dao.deleteBoard(Integer.parseInt(num), passwd);
            if (res > 0) {
                msg = "게시물 삭제 성공!! 게시물 목록 페이지로 이동합니다.";
            } else if (res == -1) {
                msg = "게시물 삭제 실패!! 비밀번호가 일치하지 않습니다.";
            } else {
                msg = "게시물 삭제 실패!! 게시물 목록 페이지로 이동합니다.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "게시물 삭제 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
            url = "main_admin.do";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
