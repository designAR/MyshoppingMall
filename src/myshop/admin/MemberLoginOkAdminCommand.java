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
            String msg = "�α��� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
            String url = "main_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "/shop_home.mall";
        }

        if (loginResult) {
            HttpSession session = req.getSession();
            session.setAttribute("adminId", id); 
            String msg = "�α��� ����!! " + id + "�� ȯ���մϴ�! ���θ� �������� �̵��մϴ�.";
            String url = "shop_home.mall";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp"; 
        } else {
            String msg = "�α��� ����!! �α��� �������� �̵��մϴ�.";
            String url = "memberLogin_admin.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
            return "message.jsp";
        }
    }
}
