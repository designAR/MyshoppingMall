package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.MemberDAO;

public class MemberDeleteAdminCommand implements CommandIf {
   
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String no = req.getParameter("no");
        MemberDAO dao = new MemberDAO();
        String msg = null, url = "memberList_admin.do";
        try {
            int res = dao.deleteMember(Integer.parseInt(no));
            if (res > 0) {
                msg = "회원 삭제 성공!! 회원 목록 페이지로 이동합니다.";
            } else {
                msg = "회원 삭제 실패!! 회원 목록 페이지로 이동합니다.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "회원 삭제 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
            url = "main_admin.do";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
