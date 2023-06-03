package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;
import myshop.admin.dto.BoardDTO;

public class BoardUpdateOkAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String numStr = req.getParameter("num");
        if (numStr == null || numStr.trim().isEmpty()) {
            req.setAttribute("msg", "��ȿ���� ���� �Խñ� ��ȣ�Դϴ�.");
            req.setAttribute("url", "javascript:history.back()");
            return "message.jsp";
        }
        
        int num = Integer.parseInt(numStr);
        String writer = req.getParameter("writer");
        String subject = req.getParameter("subject");
        String email = req.getParameter("email");
        String content = req.getParameter("content");
        String passwd = req.getParameter("passwd");

        BoardDTO dto = new BoardDTO();
        dto.setNum(num);
        dto.setWriter(writer);
        dto.setSubject(subject);
        dto.setEmail(email);
        dto.setContent(content);
        dto.setPasswd(passwd);

        BoardDAO dao = new BoardDAO();
        try {
            int result = dao.updateBoard(dto);
            if (result > 0) {
                req.setAttribute("msg", "�Խñ� ������ �Ϸ�Ǿ����ϴ�.");
                req.setAttribute("url", "boardList1_admin.do");
                return "message.jsp";
            } else {
                req.setAttribute("msg", "�Խñ� ������ �����Ͽ����ϴ�.");
                req.setAttribute("url", "javascript:history.back()");
                return "message.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "�Խñ� ���� �� DB ������ �߻��Ͽ����ϴ�.");
            req.setAttribute("url", "javascript:history.back()");
            return "message.jsp";
        }
    }
}
