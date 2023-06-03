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
                msg = "�Խù� ���� ����!! �Խù� ��� �������� �̵��մϴ�.";
            } else if (res == -1) {
                msg = "�Խù� ���� ����!! ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
            } else {
                msg = "�Խù� ���� ����!! �Խù� ��� �������� �̵��մϴ�.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "�Խù� ���� ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
            url = "main_admin.do";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "message.jsp";
    }
}
