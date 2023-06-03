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
                msg = "ȸ�� ���� ����!! ȸ�� ��� �������� �̵��մϴ�.";
            } else {
                msg = "ȸ�� ���� ����!! ȸ�� ��� �������� �̵��մϴ�.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "ȸ�� ���� ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
            url = "main_admin.do";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
