package myshop.mall;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshop.admin.dao.CategoryDAO;
import myshop.admin.dto.CategoryDTO;

public class ShopCgProdMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String code = req.getParameter("code");
		HttpSession session = req.getSession();
		ProductList plist = (ProductList)session.getAttribute("plist");
		if (plist == null) {
			plist = new ProductList();
		}
		try {
			CategoryDAO dao = new CategoryDAO();
			List<CategoryDTO> list = dao.listCate();
			if (list == null || list.size() == 0) {
				req.setAttribute("msg", "���θ� �غ��� �Դϴ�. ó���������� �̵��մϴ�.");
				req.setAttribute("url", "index.mall");
				return "message.jsp";
			}
			req.setAttribute("listCate", list);
			req.setAttribute(code, plist.selectByCode(code));
			req.setAttribute("upPath", req.getServletContext().getRealPath("/img"));
			return "WEB-INF/shop/display/mall_cgProdList.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "plist selectByCode ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url", "index.mall");
			return "message.jsp";
		}
	}

}
