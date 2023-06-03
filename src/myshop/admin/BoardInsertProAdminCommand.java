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
                message = "게시물이 성공적으로 작성되었습니다.";
                url = "boardList1_admin.do";
            } else {
                message = "게시물 작성에 실패했습니다.";
                url = "boardInsertForm_admin.do"; // 작성 중인 폼으로 돌아가는 URL
                // 작성 중인 내용을 함께 전달하기 위해 request에 속성으로 설정
                request.setAttribute("writer", writer);
                request.setAttribute("email", email);
                request.setAttribute("subject", subject);
                request.setAttribute("content", content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "게시물 추가 중 오류가 발생했습니다.";
            url = "shop_home.mall";
        }

        request.setAttribute("msg", message);
        request.setAttribute("url", url);
        return "message.jsp";
    }
}
