package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.CategoryDAO;
import myshop.admin.dto.CategoryDTO;

public class CateListAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		try {
			List<CategoryDTO> list = dao.listCate();
			req.setAttribute("listCate", list);
			return "WEB-INF/shop/admin/cate_list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			String msg = "cate list 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			String url = "main_admin.do";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
	}

}








