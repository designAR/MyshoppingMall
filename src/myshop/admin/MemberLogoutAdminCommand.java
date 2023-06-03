package myshop.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("adminId"); 

        String msg = "로그아웃되었습니다.";
        String url = "memberLogin_admin.do";
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
