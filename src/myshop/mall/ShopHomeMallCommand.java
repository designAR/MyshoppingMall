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

public class ShopHomeMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		HttpSession session = req.getSession();
		ProductList plist = (ProductList)session.getAttribute("plist");
		if (plist == null) {
			plist = new ProductList();
		}
		try {
			List<CategoryDTO> list = dao.listCate();
			if (list == null || list.size() == 0) {
				req.setAttribute("msg", "���θ� �غ��� �Դϴ�. ó���������� �̵��մϴ�.");
				req.setAttribute("url", "index.mall");
				return "message.jsp";
			}
			req.setAttribute("listCate", list);
			req.setAttribute("upPath", req.getServletContext().getRealPath("/img"));
			req.setAttribute("HIT", plist.selectBySpec("HIT"));
			req.setAttribute("NEW", plist.selectBySpec("NEW"));
			req.setAttribute("BEST", plist.selectBySpec("BEST"));
			session.setAttribute("plist", plist);
			return "WEB-INF/shop/display/mall.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "plist selectBySpec ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url", "index.mall");
			return "message.jsp";
		}
	}

}
