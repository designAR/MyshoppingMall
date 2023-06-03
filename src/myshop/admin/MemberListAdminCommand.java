package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.MemberDAO;
import myshop.admin.dto.MemberDTO;

public class MemberListAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		try {
			List<MemberDTO> list = dao.listMember(); 
			req.setAttribute("listMember", list); 
			return "WEB-INF/shop/admin/member_list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			String msg = "member list 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			String url = "main_admin.do";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
	}

}
