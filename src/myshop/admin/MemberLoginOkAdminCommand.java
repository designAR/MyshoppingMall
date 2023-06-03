package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshop.admin.dao.MemberDAO;

public class MemberLoginOkAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("passwd");

        MemberDAO dao = new MemberDAO();
        boolean loginResult;
        try {
            loginResult = dao.loginMember(id, password);
        } catch (SQLException e) {
            e.printStackTrace();
            String msg = "로그인 중 DB 오류 발생!! 관리자에게 문의하세요";
            String url = "main_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "/shop_home.mall";
        }

        if (loginResult) {
            HttpSession session = req.getSession();
            session.setAttribute("adminId", id); 
            String msg = "로그인 성공!! " + id + "님 환영합니다! 쇼핑몰 페이지로 이동합니다.";
            String url = "shop_home.mall";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp"; 
        } else {
            String msg = "로그인 실패!! 로그인 페이지로 이동합니다.";
            String url = "memberLogin_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp";
        }
    }
}
