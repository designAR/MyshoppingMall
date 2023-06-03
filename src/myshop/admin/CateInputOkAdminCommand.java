package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.CategoryDAO;
import myshop.admin.dto.CategoryDTO;

public class CateInputOkAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDTO dto = new CategoryDTO();
		dto.setCode(req.getParameter("code"));
		dto.setCname(req.getParameter("cname"));
		CategoryDAO dao = new CategoryDAO();
		String msg = null, url = null;
		try {
			int res = dao.insertCate(dto);
			if (res>0) {
				msg = "카테고리등록 성공!! 카테고리목록페이지로 이동합니다.";
				url = "cateList_admin.do";
			}else {
				msg = "카테고리등록 실패!! 카테고리등록페이지로 이동합니다.";
				url = "cateInput_admin.do";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "cate insert 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			url = "main_admin.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}
}
