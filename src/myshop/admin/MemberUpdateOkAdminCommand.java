package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.MemberDAO;
import myshop.admin.dto.MemberDTO;

public class MemberUpdateOkAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String noParam = req.getParameter("no");
        if (noParam == null) {
            req.setAttribute("msg", "ȸ�� ���� ������Ʈ�� �����Ͽ����ϴ�. ��ȿ�� ȸ�� ��ȣ�� �Է��ϼ���.");
            req.setAttribute("url", "javascript:history.back()");
            return "message.jsp";
        }

        int no = Integer.parseInt(noParam);
        String passwd = req.getParameter("passwd");
        String email = req.getParameter("email");
        String hp1 = req.getParameter("hp1");
        String hp2 = req.getParameter("hp2");
        String hp3 = req.getParameter("hp3");

        MemberDTO dto = new MemberDTO();
        dto.setNo(no);
        dto.setPasswd(passwd);
        dto.setEmail(email);
        dto.setHp1(hp1);
        dto.setHp2(hp2);
        dto.setHp3(hp3);

        MemberDAO dao = new MemberDAO();
        try {
            int result = dao.updateMember(dto);
            if (result > 0) {
                req.setAttribute("msg", "ȸ�� ���� ������Ʈ�� �Ϸ�Ǿ����ϴ�.");
                req.setAttribute("url", "memberList_admin.do");
                return "message.jsp";
            } else {
                req.setAttribute("msg", "ȸ�� ���� ������Ʈ�� �����Ͽ����ϴ�.");
                req.setAttribute("url", "javascript:history.back()");
                return "message.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "ȸ�� ���� ������Ʈ �� DB ������ �߻��Ͽ����ϴ�.");
            req.setAttribute("url", "javascript:history.back()");
            return "message.jsp";
        }
    }
}

