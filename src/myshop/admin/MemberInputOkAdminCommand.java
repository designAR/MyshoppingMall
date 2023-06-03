package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.MemberDAO;
import myshop.admin.dto.MemberDTO;

public class MemberInputOkAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MemberDTO dto = new MemberDTO();
        dto.setName(req.getParameter("name"));
        dto.setId(req.getParameter("id"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setSsn1(req.getParameter("ssn1"));
        dto.setSsn2(req.getParameter("ssn2"));
        dto.setEmail(req.getParameter("email"));
        dto.setHp1(req.getParameter("hp1"));
        dto.setHp2(req.getParameter("hp2"));
        dto.setHp3(req.getParameter("hp3"));

        MemberDAO dao = new MemberDAO();
        String msg = null;
        String url = null;
        try {
            int res = dao.insertMember(dto);
            if (res > 0) {
                msg = "회원 등록 성공!! 회원 가입 페이지로 이동합니다.";
                url = "shop_home.mall";
            } else {
                msg = "회원 등록 실패!! 회원 등록 페이지로 이동합니다.";
                url = "shop_memberInput.mall";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "회원 등록 중 DB 오류 발생!! 관리자에게 문의하세요.";
            url = "shop_home.mall";
        }

        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
