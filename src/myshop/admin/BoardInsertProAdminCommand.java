package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.BoardDAO;
import myshop.admin.dto.BoardDTO;

public class BoardInsertProAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String writer = request.getParameter("writer");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String password = request.getParameter("passwd");
        String content = request.getParameter("content");
        String ip = request.getRemoteAddr();
        
        BoardDTO dto = new BoardDTO();
        dto.setWriter(writer);
        dto.setEmail(email);
        dto.setSubject(subject);
        dto.setPasswd(password);
        dto.setContent(content);
        dto.setIp(ip);
        
        BoardDAO dao = new BoardDAO();
        String message = null;
        String url = null;
        try {
            int result = dao.insertBoard(dto);
            if (result > 0) {
                message = "�Խù��� ���������� �ۼ��Ǿ����ϴ�.";
                url = "boardList1_admin.do";
            } else {
                message = "�Խù� �ۼ��� �����߽��ϴ�.";
                url = "boardInsertForm_admin.do"; // �ۼ� ���� ������ ���ư��� URL
                // �ۼ� ���� ������ �Բ� �����ϱ� ���� request�� �Ӽ����� ����
                request.setAttribute("writer", writer);
                request.setAttribute("email", email);
                request.setAttribute("subject", subject);
                request.setAttribute("content", content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "�Խù� �߰� �� ������ �߻��߽��ϴ�.";
            url = "shop_home.mall";
        }

        request.setAttribute("msg", message);
        request.setAttribute("url", url);
        return "message.jsp";
    }
}
