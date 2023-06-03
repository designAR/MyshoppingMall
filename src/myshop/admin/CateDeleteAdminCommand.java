package myshop.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.CategoryDAO;

public class CateDeleteAdminCommand implements CommandIf {
   
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cnum = req.getParameter("cnum");
		CategoryDAO dao = new CategoryDAO();
		String msg = null, url = "cateList_admin.do";
		try {
			int res = dao.deleteCate(Integer.parseInt(cnum));
			if (res>0) {
				msg = "카테고리 삭제 성공!! 학생목록페이지로 이동합니다.";
			}else {
				msg = "카테고리 삭제 실패!! 학생목록페이지로 이동합니다.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "cate delete 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			url = "main_admin.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
