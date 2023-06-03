package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.CategoryDAO;
import myshop.admin.dto.CategoryDTO;

public class ProdInputAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		try {
			List<CategoryDTO> list = dao.listCate();
			if (list == null || list.size() == 0) {
				String msg = "ī�װ� ����� ���� �� �ּ���!!";
				String url = "cateInput_admin.do";
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				return "message.jsp";
			}
			req.setAttribute("listCate", list);
			return "WEB-INF/shop/admin/prod_input.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			String msg = "cate list ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
			String url = "main_admin.do";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
	}
}
