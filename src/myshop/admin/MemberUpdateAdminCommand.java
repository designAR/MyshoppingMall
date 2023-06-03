package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.MemberDAO;
import myshop.admin.dto.MemberDTO;

public class MemberUpdateAdminCommand implements CommandIf {

    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String no = req.getParameter("no");
        if (no == null) {
            req.setAttribute("msg", "유효한 회원 번호를 입력하세요.");
            req.setAttribute("url", "javascript:history.back()");
            return "message.jsp";
        }

        MemberDAO dao = new MemberDAO();
        try {
            MemberDTO dto = dao.getMember(Integer.parseInt(no));
            if (dto == null) {
                req.setAttribute("msg", "해당 회원 정보를 찾을 수 없습니다.");
                req.setAttribute("url", "javascript:history.back()");
                return "message.jsp";
            }

            req.setAttribute("member", dto);
            String upPath = req.getServletContext().getRealPath("/img");
            req.setAttribute("upPath", upPath);
            return "WEB-INF/shop/admin/member_update.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "member view 실행 중 DB 오류 발생!! 관리자에게 문의하세요");
            req.setAttribute("url", "main_admin.do");
            return "message.jsp";
        }
    }
}
